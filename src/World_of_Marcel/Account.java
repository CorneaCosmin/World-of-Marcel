package World_of_Marcel;

import java.util.LinkedList;
import java.util.TreeSet;

public class Account
{
    public Account(Information info,LinkedList<Character> characters,int numGames)
    {
        this.info=info;
        this.characters=characters;
        this.numGames=numGames;
    }
    static class Information {
        private Credentials cred;
        private TreeSet<String> favGames;
        private String name;
        private String country;

        private Information(InformationBuilder builder) {
            this.cred = builder.cred;
            this.favGames = builder.favGames;
            this.name = builder.name;
            this.country = builder.country;
        }

        public Credentials getCred() {
            return cred;
        }

        public TreeSet<String> getFavGames() {
            return favGames;
        }

        public String getName() {
            return name;
        }

        public String getCountry() {
            return country;
        }

        @Override
        public String toString() {
            return "Information{" +
                    "cred=" + cred +
                    ", favGames=" + favGames +
                    ", name='" + name + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }

        public static class InformationBuilder {
            private final Credentials cred;
            private TreeSet<String> favGames;
            private final String name;
            private String country;

            public InformationBuilder(Credentials cred, String name) {
                this.cred = cred;
                this.name = name;
            }

            public InformationBuilder favGames(TreeSet<String> favGames) {
                this.favGames = favGames;
                return this;
            }

            public InformationBuilder country(String country) {
                this.country = country;
                return this;
            }

            public Information build() {
                return new Information(this);
            }
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "info=" + info +
                ", characters=" + characters +
                ", numGames=" + numGames +
                '}';
    }

    Information info;
    LinkedList<Character> characters;
    int numGames;
}

package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.Account;
import fpml.confirmation.PartiesAndAccountsModel;
import fpml.confirmation.PartiesAndAccountsModel.PartiesAndAccountsModelBuilder;
import fpml.confirmation.PartiesAndAccountsModel.PartiesAndAccountsModelBuilderImpl;
import fpml.confirmation.PartiesAndAccountsModel.PartiesAndAccountsModelImpl;
import fpml.confirmation.Party;
import fpml.confirmation.meta.PartiesAndAccountsModelMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Supporting party and account definitions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartiesAndAccountsModel", builder=PartiesAndAccountsModel.PartiesAndAccountsModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartiesAndAccountsModel extends RosettaModelObject {

	PartiesAndAccountsModelMeta metaData = new PartiesAndAccountsModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 */
	List<? extends Party> getParty();
	/**
	 * Optional account information used to precisely define the origination and destination of financial instruments.
	 */
	List<? extends Account> getAccount();

	/*********************** Build Methods  ***********************/
	PartiesAndAccountsModel build();
	
	PartiesAndAccountsModel.PartiesAndAccountsModelBuilder toBuilder();
	
	static PartiesAndAccountsModel.PartiesAndAccountsModelBuilder builder() {
		return new PartiesAndAccountsModel.PartiesAndAccountsModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartiesAndAccountsModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartiesAndAccountsModel> getType() {
		return PartiesAndAccountsModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartiesAndAccountsModelBuilder extends PartiesAndAccountsModel, RosettaModelObjectBuilder {
		Party.PartyBuilder getOrCreateParty(int _index);
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int _index);
		List<? extends Account.AccountBuilder> getAccount();
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(Party party0);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(Party party1, int _idx);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(List<? extends Party> party2);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder setParty(List<? extends Party> party3);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(Account account0);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(Account account1, int _idx);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(List<? extends Account> account2);
		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder setAccount(List<? extends Account> account3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		PartiesAndAccountsModel.PartiesAndAccountsModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartiesAndAccountsModel  ***********************/
	class PartiesAndAccountsModelImpl implements PartiesAndAccountsModel {
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected PartiesAndAccountsModelImpl(PartiesAndAccountsModel.PartiesAndAccountsModelBuilder builder) {
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("account")
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public PartiesAndAccountsModel build() {
			return this;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder toBuilder() {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartiesAndAccountsModel.PartiesAndAccountsModelBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartiesAndAccountsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartiesAndAccountsModel {" +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}';
		}
	}

	/*********************** Builder Implementation of PartiesAndAccountsModel  ***********************/
	class PartiesAndAccountsModelBuilderImpl implements PartiesAndAccountsModel.PartiesAndAccountsModelBuilder {
	
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
	
		public PartiesAndAccountsModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int _index) {
		
			if (party==null) {
				this.party = new ArrayList<>();
			}
			Party.PartyBuilder result;
			return getIndex(party, _index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("account")
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount(int _index) {
		
			if (account==null) {
				this.account = new ArrayList<>();
			}
			Account.AccountBuilder result;
			return getIndex(account, _index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(Party party) {
			if (party!=null) this.party.add(party.toBuilder());
			return this;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(Party party, int _idx) {
			getIndex(this.party, _idx, () -> party.toBuilder());
			return this;
		}
		@Override 
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder setParty(List<? extends Party> partys) {
			if (partys == null)  {
				this.party = new ArrayList<>();
			}
			else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("account")
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(Account account) {
			if (account!=null) this.account.add(account.toBuilder());
			return this;
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(Account account, int _idx) {
			getIndex(this.account, _idx, () -> account.toBuilder());
			return this;
		}
		@Override 
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null)  {
				this.account = new ArrayList<>();
			}
			else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public PartiesAndAccountsModel build() {
			return new PartiesAndAccountsModel.PartiesAndAccountsModelImpl(this);
		}
		
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder prune() {
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartiesAndAccountsModel.PartiesAndAccountsModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartiesAndAccountsModel.PartiesAndAccountsModelBuilder o = (PartiesAndAccountsModel.PartiesAndAccountsModelBuilder) other;
			
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartiesAndAccountsModel _that = getType().cast(o);
		
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartiesAndAccountsModelBuilder {" +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}';
		}
	}
}

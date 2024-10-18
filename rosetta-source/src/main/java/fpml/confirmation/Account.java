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
import fpml.confirmation.Account.AccountBuilder;
import fpml.confirmation.Account.AccountBuilderImpl;
import fpml.confirmation.Account.AccountImpl;
import fpml.confirmation.AccountId;
import fpml.confirmation.AccountName;
import fpml.confirmation.AccountSequence;
import fpml.confirmation.AccountType;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.AccountMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A generic account that represents any party&#39;s account at another party. Parties may be identified by the account at another party.
 * @version ${project.version}
 */
@RosettaDataType(value="Account", builder=Account.AccountBuilderImpl.class, version="${project.version}")
public interface Account extends RosettaModelObject {

	AccountMeta metaData = new AccountMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * An account identifier. For example an Account number.
	 */
	List<? extends AccountId> getAccountId();
	/**
	 * The name by which the account is known.
	 */
	AccountName getAccountName();
	/**
	 * The type of account. e.g., Client, House
	 */
	AccountType getAccountType();
	AccountSequence getAccountSequence();
	/**
	 * A reference to the party that services/supports the account.
	 */
	PartyReference getServicingParty();
	/**
	 * The unique identifier for the account within the document.
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	Account build();
	
	Account.AccountBuilder toBuilder();
	
	static Account.AccountBuilder builder() {
		return new Account.AccountBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Account> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Account> getType() {
		return Account.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accountId"), processor, AccountId.class, getAccountId());
		processRosetta(path.newSubPath("accountName"), processor, AccountName.class, getAccountName());
		processRosetta(path.newSubPath("accountType"), processor, AccountType.class, getAccountType());
		processRosetta(path.newSubPath("accountSequence"), processor, AccountSequence.class, getAccountSequence());
		processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.class, getServicingParty());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountBuilder extends Account, RosettaModelObjectBuilder {
		AccountId.AccountIdBuilder getOrCreateAccountId(int _index);
		List<? extends AccountId.AccountIdBuilder> getAccountId();
		AccountName.AccountNameBuilder getOrCreateAccountName();
		AccountName.AccountNameBuilder getAccountName();
		AccountType.AccountTypeBuilder getOrCreateAccountType();
		AccountType.AccountTypeBuilder getAccountType();
		AccountSequence.AccountSequenceBuilder getOrCreateAccountSequence();
		AccountSequence.AccountSequenceBuilder getAccountSequence();
		PartyReference.PartyReferenceBuilder getOrCreateServicingParty();
		PartyReference.PartyReferenceBuilder getServicingParty();
		Account.AccountBuilder addAccountId(AccountId accountId0);
		Account.AccountBuilder addAccountId(AccountId accountId1, int _idx);
		Account.AccountBuilder addAccountId(List<? extends AccountId> accountId2);
		Account.AccountBuilder setAccountId(List<? extends AccountId> accountId3);
		Account.AccountBuilder setAccountName(AccountName accountName);
		Account.AccountBuilder setAccountType(AccountType accountType);
		Account.AccountBuilder setAccountSequence(AccountSequence accountSequence);
		Account.AccountBuilder setServicingParty(PartyReference servicingParty);
		Account.AccountBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accountId"), processor, AccountId.AccountIdBuilder.class, getAccountId());
			processRosetta(path.newSubPath("accountName"), processor, AccountName.AccountNameBuilder.class, getAccountName());
			processRosetta(path.newSubPath("accountType"), processor, AccountType.AccountTypeBuilder.class, getAccountType());
			processRosetta(path.newSubPath("accountSequence"), processor, AccountSequence.AccountSequenceBuilder.class, getAccountSequence());
			processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.PartyReferenceBuilder.class, getServicingParty());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Account.AccountBuilder prune();
	}

	/*********************** Immutable Implementation of Account  ***********************/
	class AccountImpl implements Account {
		private final List<? extends AccountId> accountId;
		private final AccountName accountName;
		private final AccountType accountType;
		private final AccountSequence accountSequence;
		private final PartyReference servicingParty;
		private final String id;
		
		protected AccountImpl(Account.AccountBuilder builder) {
			this.accountId = ofNullable(builder.getAccountId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.accountName = ofNullable(builder.getAccountName()).map(f->f.build()).orElse(null);
			this.accountType = ofNullable(builder.getAccountType()).map(f->f.build()).orElse(null);
			this.accountSequence = ofNullable(builder.getAccountSequence()).map(f->f.build()).orElse(null);
			this.servicingParty = ofNullable(builder.getServicingParty()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("accountId")
		public List<? extends AccountId> getAccountId() {
			return accountId;
		}
		
		@Override
		@RosettaAttribute("accountName")
		public AccountName getAccountName() {
			return accountName;
		}
		
		@Override
		@RosettaAttribute("accountType")
		public AccountType getAccountType() {
			return accountType;
		}
		
		@Override
		@RosettaAttribute("accountSequence")
		public AccountSequence getAccountSequence() {
			return accountSequence;
		}
		
		@Override
		@RosettaAttribute("servicingParty")
		public PartyReference getServicingParty() {
			return servicingParty;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Account build() {
			return this;
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			Account.AccountBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Account.AccountBuilder builder) {
			ofNullable(getAccountId()).ifPresent(builder::setAccountId);
			ofNullable(getAccountName()).ifPresent(builder::setAccountName);
			ofNullable(getAccountType()).ifPresent(builder::setAccountType);
			ofNullable(getAccountSequence()).ifPresent(builder::setAccountSequence);
			ofNullable(getServicingParty()).ifPresent(builder::setServicingParty);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accountId, _that.getAccountId())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(accountSequence, _that.getAccountSequence())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountId != null ? accountId.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.hashCode() : 0);
			_result = 31 * _result + (accountSequence != null ? accountSequence.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Account {" +
				"accountId=" + this.accountId + ", " +
				"accountName=" + this.accountName + ", " +
				"accountType=" + this.accountType + ", " +
				"accountSequence=" + this.accountSequence + ", " +
				"servicingParty=" + this.servicingParty + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Account  ***********************/
	class AccountBuilderImpl implements Account.AccountBuilder {
	
		protected List<AccountId.AccountIdBuilder> accountId = new ArrayList<>();
		protected AccountName.AccountNameBuilder accountName;
		protected AccountType.AccountTypeBuilder accountType;
		protected AccountSequence.AccountSequenceBuilder accountSequence;
		protected PartyReference.PartyReferenceBuilder servicingParty;
		protected String id;
	
		public AccountBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accountId")
		public List<? extends AccountId.AccountIdBuilder> getAccountId() {
			return accountId;
		}
		
		@Override
		public AccountId.AccountIdBuilder getOrCreateAccountId(int _index) {
		
			if (accountId==null) {
				this.accountId = new ArrayList<>();
			}
			AccountId.AccountIdBuilder result;
			return getIndex(accountId, _index, () -> {
						AccountId.AccountIdBuilder newAccountId = AccountId.builder();
						return newAccountId;
					});
		}
		
		@Override
		@RosettaAttribute("accountName")
		public AccountName.AccountNameBuilder getAccountName() {
			return accountName;
		}
		
		@Override
		public AccountName.AccountNameBuilder getOrCreateAccountName() {
			AccountName.AccountNameBuilder result;
			if (accountName!=null) {
				result = accountName;
			}
			else {
				result = accountName = AccountName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountType")
		public AccountType.AccountTypeBuilder getAccountType() {
			return accountType;
		}
		
		@Override
		public AccountType.AccountTypeBuilder getOrCreateAccountType() {
			AccountType.AccountTypeBuilder result;
			if (accountType!=null) {
				result = accountType;
			}
			else {
				result = accountType = AccountType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountSequence")
		public AccountSequence.AccountSequenceBuilder getAccountSequence() {
			return accountSequence;
		}
		
		@Override
		public AccountSequence.AccountSequenceBuilder getOrCreateAccountSequence() {
			AccountSequence.AccountSequenceBuilder result;
			if (accountSequence!=null) {
				result = accountSequence;
			}
			else {
				result = accountSequence = AccountSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("servicingParty")
		public PartyReference.PartyReferenceBuilder getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateServicingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (servicingParty!=null) {
				result = servicingParty;
			}
			else {
				result = servicingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("accountId")
		public Account.AccountBuilder addAccountId(AccountId accountId) {
			if (accountId!=null) this.accountId.add(accountId.toBuilder());
			return this;
		}
		
		@Override
		public Account.AccountBuilder addAccountId(AccountId accountId, int _idx) {
			getIndex(this.accountId, _idx, () -> accountId.toBuilder());
			return this;
		}
		@Override 
		public Account.AccountBuilder addAccountId(List<? extends AccountId> accountIds) {
			if (accountIds != null) {
				for (AccountId toAdd : accountIds) {
					this.accountId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public Account.AccountBuilder setAccountId(List<? extends AccountId> accountIds) {
			if (accountIds == null)  {
				this.accountId = new ArrayList<>();
			}
			else {
				this.accountId = accountIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("accountName")
		public Account.AccountBuilder setAccountName(AccountName accountName) {
			this.accountName = accountName==null?null:accountName.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accountType")
		public Account.AccountBuilder setAccountType(AccountType accountType) {
			this.accountType = accountType==null?null:accountType.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accountSequence")
		public Account.AccountBuilder setAccountSequence(AccountSequence accountSequence) {
			this.accountSequence = accountSequence==null?null:accountSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("servicingParty")
		public Account.AccountBuilder setServicingParty(PartyReference servicingParty) {
			this.servicingParty = servicingParty==null?null:servicingParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Account.AccountBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Account build() {
			return new Account.AccountImpl(this);
		}
		
		@Override
		public Account.AccountBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder prune() {
			accountId = accountId.stream().filter(b->b!=null).<AccountId.AccountIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (accountName!=null && !accountName.prune().hasData()) accountName = null;
			if (accountType!=null && !accountType.prune().hasData()) accountType = null;
			if (accountSequence!=null && !accountSequence.prune().hasData()) accountSequence = null;
			if (servicingParty!=null && !servicingParty.prune().hasData()) servicingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountId()!=null && getAccountId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccountName()!=null && getAccountName().hasData()) return true;
			if (getAccountType()!=null && getAccountType().hasData()) return true;
			if (getAccountSequence()!=null && getAccountSequence().hasData()) return true;
			if (getServicingParty()!=null && getServicingParty().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Account.AccountBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Account.AccountBuilder o = (Account.AccountBuilder) other;
			
			merger.mergeRosetta(getAccountId(), o.getAccountId(), this::getOrCreateAccountId);
			merger.mergeRosetta(getAccountName(), o.getAccountName(), this::setAccountName);
			merger.mergeRosetta(getAccountType(), o.getAccountType(), this::setAccountType);
			merger.mergeRosetta(getAccountSequence(), o.getAccountSequence(), this::setAccountSequence);
			merger.mergeRosetta(getServicingParty(), o.getServicingParty(), this::setServicingParty);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Account _that = getType().cast(o);
		
			if (!ListEquals.listEquals(accountId, _that.getAccountId())) return false;
			if (!Objects.equals(accountName, _that.getAccountName())) return false;
			if (!Objects.equals(accountType, _that.getAccountType())) return false;
			if (!Objects.equals(accountSequence, _that.getAccountSequence())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountId != null ? accountId.hashCode() : 0);
			_result = 31 * _result + (accountName != null ? accountName.hashCode() : 0);
			_result = 31 * _result + (accountType != null ? accountType.hashCode() : 0);
			_result = 31 * _result + (accountSequence != null ? accountSequence.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountBuilder {" +
				"accountId=" + this.accountId + ", " +
				"accountName=" + this.accountName + ", " +
				"accountType=" + this.accountType + ", " +
				"accountSequence=" + this.accountSequence + ", " +
				"servicingParty=" + this.servicingParty + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

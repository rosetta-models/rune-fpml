package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.AccountReference;
import fpml.confirmation.NovationRolesModel;
import fpml.confirmation.NovationRolesModel.NovationRolesModelBuilder;
import fpml.confirmation.NovationRolesModel.NovationRolesModelBuilderImpl;
import fpml.confirmation.NovationRolesModel.NovationRolesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.NovationRolesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The roles of the parties involved in the novation.
 * @version ${project.version}
 */
@RosettaDataType(value="NovationRolesModel", builder=NovationRolesModel.NovationRolesModelBuilderImpl.class, version="${project.version}")
public interface NovationRolesModel extends RosettaModelObject {

	NovationRolesModelMeta metaData = new NovationRolesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferor (outgoing party) in the novation. The Transferor means a party which transfers by novation to a Transferee all of its rights, liabilities, duties and obligations with respect to a Remaining Party. In a four-way novation the party referenced is Transferor 1 which transfers by novation to Transferee 1 all of its rights, liabilities, duties and obligations with respect to Transferor 2. ISDA 2004 Novation Term: Transferor (three-way novation) or Transferor 1 (four-way novation).
	 */
	PartyReference getTransferor();
	AccountReference getTransferorAccount();
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Transferee (incoming party) in the novation. Transferee means a party which accepts by way of novation all rights, liabilities, duties and obligations of a Transferor with respect to a Remaining Party. In a four-way novation the party referenced is Transferee 1 which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 1. ISDA 2004 Novation Term: Transferee (three-way novation) or Transferee 1 (four-way novation).
	 */
	PartyReference getTransferee();
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. In a five-way novation the party referenced is the Transferee&#39;s legal entity that is involved in the settlement of the fee leg of the novation transaction (this might be a different legal entity than the one that assumes the novation trade). NB: this element has been added pending confirmation of the business need/context in which it would be used, and might not appear in a subsequent draft of this schema.
	 */
	PartyReference getOtherTransferee();
	AccountReference getTransfereeAccount();
	AccountReference getOtherTransfereeAccount();
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. In a three-way novation the party referenced is the Remaining Party in the novation. Remaining Party means a party which consents to a Transferor&#39;s transfer by novation and the acceptance thereof by the Transferee of all of the Transferor&#39;s rights, liabilities, duties and obligations with respect to such Remaining Party under and with respect of the Novated Amount of a transaction. In a four-way novation the party referenced is Transferor 2 per the ISDA definition and acts in the role of a Transferor. Transferor 2 transfers by novation to Transferee 2 all of its rights, liabilities, duties and obligations with respect to Transferor 1. ISDA 2004 Novation Term: Remaining Party (three-way novation) or Transferor 2 (four-way novation).
	 */
	PartyReference getRemainingParty();
	AccountReference getRemainingPartyAccount();
	/**
	 * A pointer style reference to a party identifier defined elsewhere in the document. This element is not applicable in a three-way novation and should be omitted. In a four-way novation the party referenced is Transferee 2. Transferee 2 means a party which accepts by way of novation the rights, liabilities, duties and obligations of Transferor 2. ISDA 2004 Novation Term: Transferee 2 (four-way novation).
	 */
	PartyReference getOtherRemainingParty();
	AccountReference getOtherRemainingPartyAccount();

	/*********************** Build Methods  ***********************/
	NovationRolesModel build();
	
	NovationRolesModel.NovationRolesModelBuilder toBuilder();
	
	static NovationRolesModel.NovationRolesModelBuilder builder() {
		return new NovationRolesModel.NovationRolesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NovationRolesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NovationRolesModel> getType() {
		return NovationRolesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("transferor"), processor, PartyReference.class, getTransferor());
		processRosetta(path.newSubPath("transferorAccount"), processor, AccountReference.class, getTransferorAccount());
		processRosetta(path.newSubPath("transferee"), processor, PartyReference.class, getTransferee());
		processRosetta(path.newSubPath("otherTransferee"), processor, PartyReference.class, getOtherTransferee());
		processRosetta(path.newSubPath("transfereeAccount"), processor, AccountReference.class, getTransfereeAccount());
		processRosetta(path.newSubPath("otherTransfereeAccount"), processor, AccountReference.class, getOtherTransfereeAccount());
		processRosetta(path.newSubPath("remainingParty"), processor, PartyReference.class, getRemainingParty());
		processRosetta(path.newSubPath("remainingPartyAccount"), processor, AccountReference.class, getRemainingPartyAccount());
		processRosetta(path.newSubPath("otherRemainingParty"), processor, PartyReference.class, getOtherRemainingParty());
		processRosetta(path.newSubPath("otherRemainingPartyAccount"), processor, AccountReference.class, getOtherRemainingPartyAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NovationRolesModelBuilder extends NovationRolesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateTransferor();
		PartyReference.PartyReferenceBuilder getTransferor();
		AccountReference.AccountReferenceBuilder getOrCreateTransferorAccount();
		AccountReference.AccountReferenceBuilder getTransferorAccount();
		PartyReference.PartyReferenceBuilder getOrCreateTransferee();
		PartyReference.PartyReferenceBuilder getTransferee();
		PartyReference.PartyReferenceBuilder getOrCreateOtherTransferee();
		PartyReference.PartyReferenceBuilder getOtherTransferee();
		AccountReference.AccountReferenceBuilder getOrCreateTransfereeAccount();
		AccountReference.AccountReferenceBuilder getTransfereeAccount();
		AccountReference.AccountReferenceBuilder getOrCreateOtherTransfereeAccount();
		AccountReference.AccountReferenceBuilder getOtherTransfereeAccount();
		PartyReference.PartyReferenceBuilder getOrCreateRemainingParty();
		PartyReference.PartyReferenceBuilder getRemainingParty();
		AccountReference.AccountReferenceBuilder getOrCreateRemainingPartyAccount();
		AccountReference.AccountReferenceBuilder getRemainingPartyAccount();
		PartyReference.PartyReferenceBuilder getOrCreateOtherRemainingParty();
		PartyReference.PartyReferenceBuilder getOtherRemainingParty();
		AccountReference.AccountReferenceBuilder getOrCreateOtherRemainingPartyAccount();
		AccountReference.AccountReferenceBuilder getOtherRemainingPartyAccount();
		NovationRolesModel.NovationRolesModelBuilder setTransferor(PartyReference transferor);
		NovationRolesModel.NovationRolesModelBuilder setTransferorAccount(AccountReference transferorAccount);
		NovationRolesModel.NovationRolesModelBuilder setTransferee(PartyReference transferee);
		NovationRolesModel.NovationRolesModelBuilder setOtherTransferee(PartyReference otherTransferee);
		NovationRolesModel.NovationRolesModelBuilder setTransfereeAccount(AccountReference transfereeAccount);
		NovationRolesModel.NovationRolesModelBuilder setOtherTransfereeAccount(AccountReference otherTransfereeAccount);
		NovationRolesModel.NovationRolesModelBuilder setRemainingParty(PartyReference remainingParty);
		NovationRolesModel.NovationRolesModelBuilder setRemainingPartyAccount(AccountReference remainingPartyAccount);
		NovationRolesModel.NovationRolesModelBuilder setOtherRemainingParty(PartyReference otherRemainingParty);
		NovationRolesModel.NovationRolesModelBuilder setOtherRemainingPartyAccount(AccountReference otherRemainingPartyAccount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("transferor"), processor, PartyReference.PartyReferenceBuilder.class, getTransferor());
			processRosetta(path.newSubPath("transferorAccount"), processor, AccountReference.AccountReferenceBuilder.class, getTransferorAccount());
			processRosetta(path.newSubPath("transferee"), processor, PartyReference.PartyReferenceBuilder.class, getTransferee());
			processRosetta(path.newSubPath("otherTransferee"), processor, PartyReference.PartyReferenceBuilder.class, getOtherTransferee());
			processRosetta(path.newSubPath("transfereeAccount"), processor, AccountReference.AccountReferenceBuilder.class, getTransfereeAccount());
			processRosetta(path.newSubPath("otherTransfereeAccount"), processor, AccountReference.AccountReferenceBuilder.class, getOtherTransfereeAccount());
			processRosetta(path.newSubPath("remainingParty"), processor, PartyReference.PartyReferenceBuilder.class, getRemainingParty());
			processRosetta(path.newSubPath("remainingPartyAccount"), processor, AccountReference.AccountReferenceBuilder.class, getRemainingPartyAccount());
			processRosetta(path.newSubPath("otherRemainingParty"), processor, PartyReference.PartyReferenceBuilder.class, getOtherRemainingParty());
			processRosetta(path.newSubPath("otherRemainingPartyAccount"), processor, AccountReference.AccountReferenceBuilder.class, getOtherRemainingPartyAccount());
		}
		

		NovationRolesModel.NovationRolesModelBuilder prune();
	}

	/*********************** Immutable Implementation of NovationRolesModel  ***********************/
	class NovationRolesModelImpl implements NovationRolesModel {
		private final PartyReference transferor;
		private final AccountReference transferorAccount;
		private final PartyReference transferee;
		private final PartyReference otherTransferee;
		private final AccountReference transfereeAccount;
		private final AccountReference otherTransfereeAccount;
		private final PartyReference remainingParty;
		private final AccountReference remainingPartyAccount;
		private final PartyReference otherRemainingParty;
		private final AccountReference otherRemainingPartyAccount;
		
		protected NovationRolesModelImpl(NovationRolesModel.NovationRolesModelBuilder builder) {
			this.transferor = ofNullable(builder.getTransferor()).map(f->f.build()).orElse(null);
			this.transferorAccount = ofNullable(builder.getTransferorAccount()).map(f->f.build()).orElse(null);
			this.transferee = ofNullable(builder.getTransferee()).map(f->f.build()).orElse(null);
			this.otherTransferee = ofNullable(builder.getOtherTransferee()).map(f->f.build()).orElse(null);
			this.transfereeAccount = ofNullable(builder.getTransfereeAccount()).map(f->f.build()).orElse(null);
			this.otherTransfereeAccount = ofNullable(builder.getOtherTransfereeAccount()).map(f->f.build()).orElse(null);
			this.remainingParty = ofNullable(builder.getRemainingParty()).map(f->f.build()).orElse(null);
			this.remainingPartyAccount = ofNullable(builder.getRemainingPartyAccount()).map(f->f.build()).orElse(null);
			this.otherRemainingParty = ofNullable(builder.getOtherRemainingParty()).map(f->f.build()).orElse(null);
			this.otherRemainingPartyAccount = ofNullable(builder.getOtherRemainingPartyAccount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("transferor")
		public PartyReference getTransferor() {
			return transferor;
		}
		
		@Override
		@RosettaAttribute("transferorAccount")
		public AccountReference getTransferorAccount() {
			return transferorAccount;
		}
		
		@Override
		@RosettaAttribute("transferee")
		public PartyReference getTransferee() {
			return transferee;
		}
		
		@Override
		@RosettaAttribute("otherTransferee")
		public PartyReference getOtherTransferee() {
			return otherTransferee;
		}
		
		@Override
		@RosettaAttribute("transfereeAccount")
		public AccountReference getTransfereeAccount() {
			return transfereeAccount;
		}
		
		@Override
		@RosettaAttribute("otherTransfereeAccount")
		public AccountReference getOtherTransfereeAccount() {
			return otherTransfereeAccount;
		}
		
		@Override
		@RosettaAttribute("remainingParty")
		public PartyReference getRemainingParty() {
			return remainingParty;
		}
		
		@Override
		@RosettaAttribute("remainingPartyAccount")
		public AccountReference getRemainingPartyAccount() {
			return remainingPartyAccount;
		}
		
		@Override
		@RosettaAttribute("otherRemainingParty")
		public PartyReference getOtherRemainingParty() {
			return otherRemainingParty;
		}
		
		@Override
		@RosettaAttribute("otherRemainingPartyAccount")
		public AccountReference getOtherRemainingPartyAccount() {
			return otherRemainingPartyAccount;
		}
		
		@Override
		public NovationRolesModel build() {
			return this;
		}
		
		@Override
		public NovationRolesModel.NovationRolesModelBuilder toBuilder() {
			NovationRolesModel.NovationRolesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NovationRolesModel.NovationRolesModelBuilder builder) {
			ofNullable(getTransferor()).ifPresent(builder::setTransferor);
			ofNullable(getTransferorAccount()).ifPresent(builder::setTransferorAccount);
			ofNullable(getTransferee()).ifPresent(builder::setTransferee);
			ofNullable(getOtherTransferee()).ifPresent(builder::setOtherTransferee);
			ofNullable(getTransfereeAccount()).ifPresent(builder::setTransfereeAccount);
			ofNullable(getOtherTransfereeAccount()).ifPresent(builder::setOtherTransfereeAccount);
			ofNullable(getRemainingParty()).ifPresent(builder::setRemainingParty);
			ofNullable(getRemainingPartyAccount()).ifPresent(builder::setRemainingPartyAccount);
			ofNullable(getOtherRemainingParty()).ifPresent(builder::setOtherRemainingParty);
			ofNullable(getOtherRemainingPartyAccount()).ifPresent(builder::setOtherRemainingPartyAccount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(transferor, _that.getTransferor())) return false;
			if (!Objects.equals(transferorAccount, _that.getTransferorAccount())) return false;
			if (!Objects.equals(transferee, _that.getTransferee())) return false;
			if (!Objects.equals(otherTransferee, _that.getOtherTransferee())) return false;
			if (!Objects.equals(transfereeAccount, _that.getTransfereeAccount())) return false;
			if (!Objects.equals(otherTransfereeAccount, _that.getOtherTransfereeAccount())) return false;
			if (!Objects.equals(remainingParty, _that.getRemainingParty())) return false;
			if (!Objects.equals(remainingPartyAccount, _that.getRemainingPartyAccount())) return false;
			if (!Objects.equals(otherRemainingParty, _that.getOtherRemainingParty())) return false;
			if (!Objects.equals(otherRemainingPartyAccount, _that.getOtherRemainingPartyAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferor != null ? transferor.hashCode() : 0);
			_result = 31 * _result + (transferorAccount != null ? transferorAccount.hashCode() : 0);
			_result = 31 * _result + (transferee != null ? transferee.hashCode() : 0);
			_result = 31 * _result + (otherTransferee != null ? otherTransferee.hashCode() : 0);
			_result = 31 * _result + (transfereeAccount != null ? transfereeAccount.hashCode() : 0);
			_result = 31 * _result + (otherTransfereeAccount != null ? otherTransfereeAccount.hashCode() : 0);
			_result = 31 * _result + (remainingParty != null ? remainingParty.hashCode() : 0);
			_result = 31 * _result + (remainingPartyAccount != null ? remainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (otherRemainingParty != null ? otherRemainingParty.hashCode() : 0);
			_result = 31 * _result + (otherRemainingPartyAccount != null ? otherRemainingPartyAccount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationRolesModel {" +
				"transferor=" + this.transferor + ", " +
				"transferorAccount=" + this.transferorAccount + ", " +
				"transferee=" + this.transferee + ", " +
				"otherTransferee=" + this.otherTransferee + ", " +
				"transfereeAccount=" + this.transfereeAccount + ", " +
				"otherTransfereeAccount=" + this.otherTransfereeAccount + ", " +
				"remainingParty=" + this.remainingParty + ", " +
				"remainingPartyAccount=" + this.remainingPartyAccount + ", " +
				"otherRemainingParty=" + this.otherRemainingParty + ", " +
				"otherRemainingPartyAccount=" + this.otherRemainingPartyAccount +
			'}';
		}
	}

	/*********************** Builder Implementation of NovationRolesModel  ***********************/
	class NovationRolesModelBuilderImpl implements NovationRolesModel.NovationRolesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder transferor;
		protected AccountReference.AccountReferenceBuilder transferorAccount;
		protected PartyReference.PartyReferenceBuilder transferee;
		protected PartyReference.PartyReferenceBuilder otherTransferee;
		protected AccountReference.AccountReferenceBuilder transfereeAccount;
		protected AccountReference.AccountReferenceBuilder otherTransfereeAccount;
		protected PartyReference.PartyReferenceBuilder remainingParty;
		protected AccountReference.AccountReferenceBuilder remainingPartyAccount;
		protected PartyReference.PartyReferenceBuilder otherRemainingParty;
		protected AccountReference.AccountReferenceBuilder otherRemainingPartyAccount;
	
		public NovationRolesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("transferor")
		public PartyReference.PartyReferenceBuilder getTransferor() {
			return transferor;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTransferor() {
			PartyReference.PartyReferenceBuilder result;
			if (transferor!=null) {
				result = transferor;
			}
			else {
				result = transferor = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferorAccount")
		public AccountReference.AccountReferenceBuilder getTransferorAccount() {
			return transferorAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateTransferorAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (transferorAccount!=null) {
				result = transferorAccount;
			}
			else {
				result = transferorAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferee")
		public PartyReference.PartyReferenceBuilder getTransferee() {
			return transferee;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateTransferee() {
			PartyReference.PartyReferenceBuilder result;
			if (transferee!=null) {
				result = transferee;
			}
			else {
				result = transferee = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherTransferee")
		public PartyReference.PartyReferenceBuilder getOtherTransferee() {
			return otherTransferee;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOtherTransferee() {
			PartyReference.PartyReferenceBuilder result;
			if (otherTransferee!=null) {
				result = otherTransferee;
			}
			else {
				result = otherTransferee = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transfereeAccount")
		public AccountReference.AccountReferenceBuilder getTransfereeAccount() {
			return transfereeAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateTransfereeAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (transfereeAccount!=null) {
				result = transfereeAccount;
			}
			else {
				result = transfereeAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherTransfereeAccount")
		public AccountReference.AccountReferenceBuilder getOtherTransfereeAccount() {
			return otherTransfereeAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateOtherTransfereeAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (otherTransfereeAccount!=null) {
				result = otherTransfereeAccount;
			}
			else {
				result = otherTransfereeAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remainingParty")
		public PartyReference.PartyReferenceBuilder getRemainingParty() {
			return remainingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateRemainingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (remainingParty!=null) {
				result = remainingParty;
			}
			else {
				result = remainingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("remainingPartyAccount")
		public AccountReference.AccountReferenceBuilder getRemainingPartyAccount() {
			return remainingPartyAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateRemainingPartyAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (remainingPartyAccount!=null) {
				result = remainingPartyAccount;
			}
			else {
				result = remainingPartyAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherRemainingParty")
		public PartyReference.PartyReferenceBuilder getOtherRemainingParty() {
			return otherRemainingParty;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateOtherRemainingParty() {
			PartyReference.PartyReferenceBuilder result;
			if (otherRemainingParty!=null) {
				result = otherRemainingParty;
			}
			else {
				result = otherRemainingParty = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("otherRemainingPartyAccount")
		public AccountReference.AccountReferenceBuilder getOtherRemainingPartyAccount() {
			return otherRemainingPartyAccount;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateOtherRemainingPartyAccount() {
			AccountReference.AccountReferenceBuilder result;
			if (otherRemainingPartyAccount!=null) {
				result = otherRemainingPartyAccount;
			}
			else {
				result = otherRemainingPartyAccount = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("transferor")
		public NovationRolesModel.NovationRolesModelBuilder setTransferor(PartyReference transferor) {
			this.transferor = transferor==null?null:transferor.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferorAccount")
		public NovationRolesModel.NovationRolesModelBuilder setTransferorAccount(AccountReference transferorAccount) {
			this.transferorAccount = transferorAccount==null?null:transferorAccount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transferee")
		public NovationRolesModel.NovationRolesModelBuilder setTransferee(PartyReference transferee) {
			this.transferee = transferee==null?null:transferee.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("otherTransferee")
		public NovationRolesModel.NovationRolesModelBuilder setOtherTransferee(PartyReference otherTransferee) {
			this.otherTransferee = otherTransferee==null?null:otherTransferee.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("transfereeAccount")
		public NovationRolesModel.NovationRolesModelBuilder setTransfereeAccount(AccountReference transfereeAccount) {
			this.transfereeAccount = transfereeAccount==null?null:transfereeAccount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("otherTransfereeAccount")
		public NovationRolesModel.NovationRolesModelBuilder setOtherTransfereeAccount(AccountReference otherTransfereeAccount) {
			this.otherTransfereeAccount = otherTransfereeAccount==null?null:otherTransfereeAccount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("remainingParty")
		public NovationRolesModel.NovationRolesModelBuilder setRemainingParty(PartyReference remainingParty) {
			this.remainingParty = remainingParty==null?null:remainingParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("remainingPartyAccount")
		public NovationRolesModel.NovationRolesModelBuilder setRemainingPartyAccount(AccountReference remainingPartyAccount) {
			this.remainingPartyAccount = remainingPartyAccount==null?null:remainingPartyAccount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("otherRemainingParty")
		public NovationRolesModel.NovationRolesModelBuilder setOtherRemainingParty(PartyReference otherRemainingParty) {
			this.otherRemainingParty = otherRemainingParty==null?null:otherRemainingParty.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("otherRemainingPartyAccount")
		public NovationRolesModel.NovationRolesModelBuilder setOtherRemainingPartyAccount(AccountReference otherRemainingPartyAccount) {
			this.otherRemainingPartyAccount = otherRemainingPartyAccount==null?null:otherRemainingPartyAccount.toBuilder();
			return this;
		}
		
		@Override
		public NovationRolesModel build() {
			return new NovationRolesModel.NovationRolesModelImpl(this);
		}
		
		@Override
		public NovationRolesModel.NovationRolesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationRolesModel.NovationRolesModelBuilder prune() {
			if (transferor!=null && !transferor.prune().hasData()) transferor = null;
			if (transferorAccount!=null && !transferorAccount.prune().hasData()) transferorAccount = null;
			if (transferee!=null && !transferee.prune().hasData()) transferee = null;
			if (otherTransferee!=null && !otherTransferee.prune().hasData()) otherTransferee = null;
			if (transfereeAccount!=null && !transfereeAccount.prune().hasData()) transfereeAccount = null;
			if (otherTransfereeAccount!=null && !otherTransfereeAccount.prune().hasData()) otherTransfereeAccount = null;
			if (remainingParty!=null && !remainingParty.prune().hasData()) remainingParty = null;
			if (remainingPartyAccount!=null && !remainingPartyAccount.prune().hasData()) remainingPartyAccount = null;
			if (otherRemainingParty!=null && !otherRemainingParty.prune().hasData()) otherRemainingParty = null;
			if (otherRemainingPartyAccount!=null && !otherRemainingPartyAccount.prune().hasData()) otherRemainingPartyAccount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTransferor()!=null && getTransferor().hasData()) return true;
			if (getTransferorAccount()!=null && getTransferorAccount().hasData()) return true;
			if (getTransferee()!=null && getTransferee().hasData()) return true;
			if (getOtherTransferee()!=null && getOtherTransferee().hasData()) return true;
			if (getTransfereeAccount()!=null && getTransfereeAccount().hasData()) return true;
			if (getOtherTransfereeAccount()!=null && getOtherTransfereeAccount().hasData()) return true;
			if (getRemainingParty()!=null && getRemainingParty().hasData()) return true;
			if (getRemainingPartyAccount()!=null && getRemainingPartyAccount().hasData()) return true;
			if (getOtherRemainingParty()!=null && getOtherRemainingParty().hasData()) return true;
			if (getOtherRemainingPartyAccount()!=null && getOtherRemainingPartyAccount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NovationRolesModel.NovationRolesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NovationRolesModel.NovationRolesModelBuilder o = (NovationRolesModel.NovationRolesModelBuilder) other;
			
			merger.mergeRosetta(getTransferor(), o.getTransferor(), this::setTransferor);
			merger.mergeRosetta(getTransferorAccount(), o.getTransferorAccount(), this::setTransferorAccount);
			merger.mergeRosetta(getTransferee(), o.getTransferee(), this::setTransferee);
			merger.mergeRosetta(getOtherTransferee(), o.getOtherTransferee(), this::setOtherTransferee);
			merger.mergeRosetta(getTransfereeAccount(), o.getTransfereeAccount(), this::setTransfereeAccount);
			merger.mergeRosetta(getOtherTransfereeAccount(), o.getOtherTransfereeAccount(), this::setOtherTransfereeAccount);
			merger.mergeRosetta(getRemainingParty(), o.getRemainingParty(), this::setRemainingParty);
			merger.mergeRosetta(getRemainingPartyAccount(), o.getRemainingPartyAccount(), this::setRemainingPartyAccount);
			merger.mergeRosetta(getOtherRemainingParty(), o.getOtherRemainingParty(), this::setOtherRemainingParty);
			merger.mergeRosetta(getOtherRemainingPartyAccount(), o.getOtherRemainingPartyAccount(), this::setOtherRemainingPartyAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NovationRolesModel _that = getType().cast(o);
		
			if (!Objects.equals(transferor, _that.getTransferor())) return false;
			if (!Objects.equals(transferorAccount, _that.getTransferorAccount())) return false;
			if (!Objects.equals(transferee, _that.getTransferee())) return false;
			if (!Objects.equals(otherTransferee, _that.getOtherTransferee())) return false;
			if (!Objects.equals(transfereeAccount, _that.getTransfereeAccount())) return false;
			if (!Objects.equals(otherTransfereeAccount, _that.getOtherTransfereeAccount())) return false;
			if (!Objects.equals(remainingParty, _that.getRemainingParty())) return false;
			if (!Objects.equals(remainingPartyAccount, _that.getRemainingPartyAccount())) return false;
			if (!Objects.equals(otherRemainingParty, _that.getOtherRemainingParty())) return false;
			if (!Objects.equals(otherRemainingPartyAccount, _that.getOtherRemainingPartyAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (transferor != null ? transferor.hashCode() : 0);
			_result = 31 * _result + (transferorAccount != null ? transferorAccount.hashCode() : 0);
			_result = 31 * _result + (transferee != null ? transferee.hashCode() : 0);
			_result = 31 * _result + (otherTransferee != null ? otherTransferee.hashCode() : 0);
			_result = 31 * _result + (transfereeAccount != null ? transfereeAccount.hashCode() : 0);
			_result = 31 * _result + (otherTransfereeAccount != null ? otherTransfereeAccount.hashCode() : 0);
			_result = 31 * _result + (remainingParty != null ? remainingParty.hashCode() : 0);
			_result = 31 * _result + (remainingPartyAccount != null ? remainingPartyAccount.hashCode() : 0);
			_result = 31 * _result + (otherRemainingParty != null ? otherRemainingParty.hashCode() : 0);
			_result = 31 * _result + (otherRemainingPartyAccount != null ? otherRemainingPartyAccount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NovationRolesModelBuilder {" +
				"transferor=" + this.transferor + ", " +
				"transferorAccount=" + this.transferorAccount + ", " +
				"transferee=" + this.transferee + ", " +
				"otherTransferee=" + this.otherTransferee + ", " +
				"transfereeAccount=" + this.transfereeAccount + ", " +
				"otherTransfereeAccount=" + this.otherTransfereeAccount + ", " +
				"remainingParty=" + this.remainingParty + ", " +
				"remainingPartyAccount=" + this.remainingPartyAccount + ", " +
				"otherRemainingParty=" + this.otherRemainingParty + ", " +
				"otherRemainingPartyAccount=" + this.otherRemainingPartyAccount +
			'}';
		}
	}
}

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
import fpml.confirmation.AccountSequence;
import fpml.confirmation.AccountSequence.AccountSequenceBuilder;
import fpml.confirmation.AccountSequence.AccountSequenceBuilderImpl;
import fpml.confirmation.AccountSequence.AccountSequenceImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.AccountSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="AccountSequence", builder=AccountSequence.AccountSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface AccountSequence extends RosettaModelObject {

	AccountSequenceMeta metaData = new AccountSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the party beneficiary of the account.
	 */
	PartyReference getAccountBeneficiary();
	/**
	 * A reference to the party that services/supports the account.
	 */
	PartyReference getServicingParty();

	/*********************** Build Methods  ***********************/
	AccountSequence build();
	
	AccountSequence.AccountSequenceBuilder toBuilder();
	
	static AccountSequence.AccountSequenceBuilder builder() {
		return new AccountSequence.AccountSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AccountSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AccountSequence> getType() {
		return AccountSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("accountBeneficiary"), processor, PartyReference.class, getAccountBeneficiary());
		processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.class, getServicingParty());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AccountSequenceBuilder extends AccountSequence, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreateAccountBeneficiary();
		PartyReference.PartyReferenceBuilder getAccountBeneficiary();
		PartyReference.PartyReferenceBuilder getOrCreateServicingParty();
		PartyReference.PartyReferenceBuilder getServicingParty();
		AccountSequence.AccountSequenceBuilder setAccountBeneficiary(PartyReference accountBeneficiary);
		AccountSequence.AccountSequenceBuilder setServicingParty(PartyReference servicingParty);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("accountBeneficiary"), processor, PartyReference.PartyReferenceBuilder.class, getAccountBeneficiary());
			processRosetta(path.newSubPath("servicingParty"), processor, PartyReference.PartyReferenceBuilder.class, getServicingParty());
		}
		

		AccountSequence.AccountSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of AccountSequence  ***********************/
	class AccountSequenceImpl implements AccountSequence {
		private final PartyReference accountBeneficiary;
		private final PartyReference servicingParty;
		
		protected AccountSequenceImpl(AccountSequence.AccountSequenceBuilder builder) {
			this.accountBeneficiary = ofNullable(builder.getAccountBeneficiary()).map(f->f.build()).orElse(null);
			this.servicingParty = ofNullable(builder.getServicingParty()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("accountBeneficiary")
		public PartyReference getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		@RosettaAttribute("servicingParty")
		public PartyReference getServicingParty() {
			return servicingParty;
		}
		
		@Override
		public AccountSequence build() {
			return this;
		}
		
		@Override
		public AccountSequence.AccountSequenceBuilder toBuilder() {
			AccountSequence.AccountSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AccountSequence.AccountSequenceBuilder builder) {
			ofNullable(getAccountBeneficiary()).ifPresent(builder::setAccountBeneficiary);
			ofNullable(getServicingParty()).ifPresent(builder::setServicingParty);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountSequence _that = getType().cast(o);
		
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountSequence {" +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}

	/*********************** Builder Implementation of AccountSequence  ***********************/
	class AccountSequenceBuilderImpl implements AccountSequence.AccountSequenceBuilder {
	
		protected PartyReference.PartyReferenceBuilder accountBeneficiary;
		protected PartyReference.PartyReferenceBuilder servicingParty;
	
		public AccountSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("accountBeneficiary")
		public PartyReference.PartyReferenceBuilder getAccountBeneficiary() {
			return accountBeneficiary;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateAccountBeneficiary() {
			PartyReference.PartyReferenceBuilder result;
			if (accountBeneficiary!=null) {
				result = accountBeneficiary;
			}
			else {
				result = accountBeneficiary = PartyReference.builder();
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
		@RosettaAttribute("accountBeneficiary")
		public AccountSequence.AccountSequenceBuilder setAccountBeneficiary(PartyReference accountBeneficiary) {
			this.accountBeneficiary = accountBeneficiary==null?null:accountBeneficiary.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("servicingParty")
		public AccountSequence.AccountSequenceBuilder setServicingParty(PartyReference servicingParty) {
			this.servicingParty = servicingParty==null?null:servicingParty.toBuilder();
			return this;
		}
		
		@Override
		public AccountSequence build() {
			return new AccountSequence.AccountSequenceImpl(this);
		}
		
		@Override
		public AccountSequence.AccountSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountSequence.AccountSequenceBuilder prune() {
			if (accountBeneficiary!=null && !accountBeneficiary.prune().hasData()) accountBeneficiary = null;
			if (servicingParty!=null && !servicingParty.prune().hasData()) servicingParty = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAccountBeneficiary()!=null && getAccountBeneficiary().hasData()) return true;
			if (getServicingParty()!=null && getServicingParty().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AccountSequence.AccountSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AccountSequence.AccountSequenceBuilder o = (AccountSequence.AccountSequenceBuilder) other;
			
			merger.mergeRosetta(getAccountBeneficiary(), o.getAccountBeneficiary(), this::setAccountBeneficiary);
			merger.mergeRosetta(getServicingParty(), o.getServicingParty(), this::setServicingParty);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AccountSequence _that = getType().cast(o);
		
			if (!Objects.equals(accountBeneficiary, _that.getAccountBeneficiary())) return false;
			if (!Objects.equals(servicingParty, _that.getServicingParty())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (accountBeneficiary != null ? accountBeneficiary.hashCode() : 0);
			_result = 31 * _result + (servicingParty != null ? servicingParty.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AccountSequenceBuilder {" +
				"accountBeneficiary=" + this.accountBeneficiary + ", " +
				"servicingParty=" + this.servicingParty +
			'}';
		}
	}
}

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
import fpml.confirmation.PartyAndAccountReferencesModel;
import fpml.confirmation.PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder;
import fpml.confirmation.PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilderImpl;
import fpml.confirmation.PartyAndAccountReferencesModel.PartyAndAccountReferencesModelImpl;
import fpml.confirmation.PartyReference;
import fpml.confirmation.meta.PartyAndAccountReferencesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PartyAndAccountReferencesModel", builder=PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PartyAndAccountReferencesModel extends RosettaModelObject {

	PartyAndAccountReferencesModelMeta metaData = new PartyAndAccountReferencesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to a party.
	 */
	PartyReference getPartyReference();
	/**
	 * Reference to an account.
	 */
	AccountReference getAccountReference();

	/*********************** Build Methods  ***********************/
	PartyAndAccountReferencesModel build();
	
	PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder toBuilder();
	
	static PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder builder() {
		return new PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PartyAndAccountReferencesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PartyAndAccountReferencesModel> getType() {
		return PartyAndAccountReferencesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partyReference"), processor, PartyReference.class, getPartyReference());
		processRosetta(path.newSubPath("accountReference"), processor, AccountReference.class, getAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PartyAndAccountReferencesModelBuilder extends PartyAndAccountReferencesModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePartyReference();
		PartyReference.PartyReferenceBuilder getPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreateAccountReference();
		AccountReference.AccountReferenceBuilder getAccountReference();
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder setPartyReference(PartyReference partyReference);
		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder setAccountReference(AccountReference accountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPartyReference());
			processRosetta(path.newSubPath("accountReference"), processor, AccountReference.AccountReferenceBuilder.class, getAccountReference());
		}
		

		PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder prune();
	}

	/*********************** Immutable Implementation of PartyAndAccountReferencesModel  ***********************/
	class PartyAndAccountReferencesModelImpl implements PartyAndAccountReferencesModel {
		private final PartyReference partyReference;
		private final AccountReference accountReference;
		
		protected PartyAndAccountReferencesModelImpl(PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder builder) {
			this.partyReference = ofNullable(builder.getPartyReference()).map(f->f.build()).orElse(null);
			this.accountReference = ofNullable(builder.getAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference getPartyReference() {
			return partyReference;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		public AccountReference getAccountReference() {
			return accountReference;
		}
		
		@Override
		public PartyAndAccountReferencesModel build() {
			return this;
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder toBuilder() {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder builder) {
			ofNullable(getPartyReference()).ifPresent(builder::setPartyReference);
			ofNullable(getAccountReference()).ifPresent(builder::setAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAndAccountReferencesModel _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAndAccountReferencesModel {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PartyAndAccountReferencesModel  ***********************/
	class PartyAndAccountReferencesModelBuilderImpl implements PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder partyReference;
		protected AccountReference.AccountReferenceBuilder accountReference;
	
		public PartyAndAccountReferencesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partyReference")
		public PartyReference.PartyReferenceBuilder getPartyReference() {
			return partyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (partyReference!=null) {
				result = partyReference;
			}
			else {
				result = partyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("accountReference")
		public AccountReference.AccountReferenceBuilder getAccountReference() {
			return accountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreateAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (accountReference!=null) {
				result = accountReference;
			}
			else {
				result = accountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyReference")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder setPartyReference(PartyReference partyReference) {
			this.partyReference = partyReference==null?null:partyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("accountReference")
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder setAccountReference(AccountReference accountReference) {
			this.accountReference = accountReference==null?null:accountReference.toBuilder();
			return this;
		}
		
		@Override
		public PartyAndAccountReferencesModel build() {
			return new PartyAndAccountReferencesModel.PartyAndAccountReferencesModelImpl(this);
		}
		
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder prune() {
			if (partyReference!=null && !partyReference.prune().hasData()) partyReference = null;
			if (accountReference!=null && !accountReference.prune().hasData()) accountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartyReference()!=null && getPartyReference().hasData()) return true;
			if (getAccountReference()!=null && getAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder o = (PartyAndAccountReferencesModel.PartyAndAccountReferencesModelBuilder) other;
			
			merger.mergeRosetta(getPartyReference(), o.getPartyReference(), this::setPartyReference);
			merger.mergeRosetta(getAccountReference(), o.getAccountReference(), this::setAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PartyAndAccountReferencesModel _that = getType().cast(o);
		
			if (!Objects.equals(partyReference, _that.getPartyReference())) return false;
			if (!Objects.equals(accountReference, _that.getAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partyReference != null ? partyReference.hashCode() : 0);
			_result = 31 * _result + (accountReference != null ? accountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PartyAndAccountReferencesModelBuilder {" +
				"partyReference=" + this.partyReference + ", " +
				"accountReference=" + this.accountReference +
			'}';
		}
	}
}

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
import fpml.confirmation.PartyReference;
import fpml.confirmation.PayerModel;
import fpml.confirmation.PayerModel.PayerModelBuilder;
import fpml.confirmation.PayerModel.PayerModelBuilderImpl;
import fpml.confirmation.PayerModel.PayerModelImpl;
import fpml.confirmation.meta.PayerModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="PayerModel", builder=PayerModel.PayerModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface PayerModel extends RosettaModelObject {

	PayerModelMeta metaData = new PayerModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to the party responsible for making the payments defined by this structure.
	 */
	PartyReference getPayerPartyReference();
	/**
	 * A reference to the account responsible for making the payments defined by this structure.
	 */
	AccountReference getPayerAccountReference();

	/*********************** Build Methods  ***********************/
	PayerModel build();
	
	PayerModel.PayerModelBuilder toBuilder();
	
	static PayerModel.PayerModelBuilder builder() {
		return new PayerModel.PayerModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PayerModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PayerModel> getType() {
		return PayerModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.class, getPayerPartyReference());
		processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.class, getPayerAccountReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PayerModelBuilder extends PayerModel, RosettaModelObjectBuilder {
		PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference();
		PartyReference.PartyReferenceBuilder getPayerPartyReference();
		AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference();
		AccountReference.AccountReferenceBuilder getPayerAccountReference();
		PayerModel.PayerModelBuilder setPayerPartyReference(PartyReference payerPartyReference);
		PayerModel.PayerModelBuilder setPayerAccountReference(AccountReference payerAccountReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getPayerPartyReference());
			processRosetta(path.newSubPath("payerAccountReference"), processor, AccountReference.AccountReferenceBuilder.class, getPayerAccountReference());
		}
		

		PayerModel.PayerModelBuilder prune();
	}

	/*********************** Immutable Implementation of PayerModel  ***********************/
	class PayerModelImpl implements PayerModel {
		private final PartyReference payerPartyReference;
		private final AccountReference payerAccountReference;
		
		protected PayerModelImpl(PayerModel.PayerModelBuilder builder) {
			this.payerPartyReference = ofNullable(builder.getPayerPartyReference()).map(f->f.build()).orElse(null);
			this.payerAccountReference = ofNullable(builder.getPayerAccountReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		public PartyReference getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		public AccountReference getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public PayerModel build() {
			return this;
		}
		
		@Override
		public PayerModel.PayerModelBuilder toBuilder() {
			PayerModel.PayerModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PayerModel.PayerModelBuilder builder) {
			ofNullable(getPayerPartyReference()).ifPresent(builder::setPayerPartyReference);
			ofNullable(getPayerAccountReference()).ifPresent(builder::setPayerAccountReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerModel _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerModel {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PayerModel  ***********************/
	class PayerModelBuilderImpl implements PayerModel.PayerModelBuilder {
	
		protected PartyReference.PartyReferenceBuilder payerPartyReference;
		protected AccountReference.AccountReferenceBuilder payerAccountReference;
	
		public PayerModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerPartyReference")
		public PartyReference.PartyReferenceBuilder getPayerPartyReference() {
			return payerPartyReference;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreatePayerPartyReference() {
			PartyReference.PartyReferenceBuilder result;
			if (payerPartyReference!=null) {
				result = payerPartyReference;
			}
			else {
				result = payerPartyReference = PartyReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerAccountReference")
		public AccountReference.AccountReferenceBuilder getPayerAccountReference() {
			return payerAccountReference;
		}
		
		@Override
		public AccountReference.AccountReferenceBuilder getOrCreatePayerAccountReference() {
			AccountReference.AccountReferenceBuilder result;
			if (payerAccountReference!=null) {
				result = payerAccountReference;
			}
			else {
				result = payerAccountReference = AccountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("payerPartyReference")
		public PayerModel.PayerModelBuilder setPayerPartyReference(PartyReference payerPartyReference) {
			this.payerPartyReference = payerPartyReference==null?null:payerPartyReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payerAccountReference")
		public PayerModel.PayerModelBuilder setPayerAccountReference(AccountReference payerAccountReference) {
			this.payerAccountReference = payerAccountReference==null?null:payerAccountReference.toBuilder();
			return this;
		}
		
		@Override
		public PayerModel build() {
			return new PayerModel.PayerModelImpl(this);
		}
		
		@Override
		public PayerModel.PayerModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerModel.PayerModelBuilder prune() {
			if (payerPartyReference!=null && !payerPartyReference.prune().hasData()) payerPartyReference = null;
			if (payerAccountReference!=null && !payerAccountReference.prune().hasData()) payerAccountReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerPartyReference()!=null && getPayerPartyReference().hasData()) return true;
			if (getPayerAccountReference()!=null && getPayerAccountReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PayerModel.PayerModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PayerModel.PayerModelBuilder o = (PayerModel.PayerModelBuilder) other;
			
			merger.mergeRosetta(getPayerPartyReference(), o.getPayerPartyReference(), this::setPayerPartyReference);
			merger.mergeRosetta(getPayerAccountReference(), o.getPayerAccountReference(), this::setPayerAccountReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PayerModel _that = getType().cast(o);
		
			if (!Objects.equals(payerPartyReference, _that.getPayerPartyReference())) return false;
			if (!Objects.equals(payerAccountReference, _that.getPayerAccountReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerPartyReference != null ? payerPartyReference.hashCode() : 0);
			_result = 31 * _result + (payerAccountReference != null ? payerAccountReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PayerModelBuilder {" +
				"payerPartyReference=" + this.payerPartyReference + ", " +
				"payerAccountReference=" + this.payerAccountReference +
			'}';
		}
	}
}

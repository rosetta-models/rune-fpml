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
import fpml.confirmation.AssetReference;
import fpml.confirmation.PassThroughItem;
import fpml.confirmation.PassThroughItem.PassThroughItemBuilder;
import fpml.confirmation.PassThroughItem.PassThroughItemBuilderImpl;
import fpml.confirmation.PassThroughItem.PassThroughItemImpl;
import fpml.confirmation.PayerReceiverModel;
import fpml.confirmation.meta.PassThroughItemMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Type to represent a single pass through payment.
 * @version ${project.version}
 */
@RosettaDataType(value="PassThroughItem", builder=PassThroughItem.PassThroughItemBuilderImpl.class, version="${project.version}")
public interface PassThroughItem extends RosettaModelObject {

	PassThroughItemMeta metaData = new PassThroughItemMeta();

	/*********************** Getter Methods  ***********************/
	PayerReceiverModel getPayerReceiverModel();
	/**
	 * Reference to the underlyer whose payments are being passed through.
	 */
	AssetReference getUnderlyerReference();
	/**
	 * Percentage of payments from the underlyer which are passed through.
	 */
	BigDecimal getPassThroughPercentage();

	/*********************** Build Methods  ***********************/
	PassThroughItem build();
	
	PassThroughItem.PassThroughItemBuilder toBuilder();
	
	static PassThroughItem.PassThroughItemBuilder builder() {
		return new PassThroughItem.PassThroughItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PassThroughItem> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PassThroughItem> getType() {
		return PassThroughItem.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.class, getPayerReceiverModel());
		processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.class, getUnderlyerReference());
		processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PassThroughItemBuilder extends PassThroughItem, RosettaModelObjectBuilder {
		PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel();
		PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel();
		AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference();
		AssetReference.AssetReferenceBuilder getUnderlyerReference();
		PassThroughItem.PassThroughItemBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel);
		PassThroughItem.PassThroughItemBuilder setUnderlyerReference(AssetReference underlyerReference);
		PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal passThroughPercentage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("payerReceiverModel"), processor, PayerReceiverModel.PayerReceiverModelBuilder.class, getPayerReceiverModel());
			processRosetta(path.newSubPath("underlyerReference"), processor, AssetReference.AssetReferenceBuilder.class, getUnderlyerReference());
			processor.processBasic(path.newSubPath("passThroughPercentage"), BigDecimal.class, getPassThroughPercentage(), this);
		}
		

		PassThroughItem.PassThroughItemBuilder prune();
	}

	/*********************** Immutable Implementation of PassThroughItem  ***********************/
	class PassThroughItemImpl implements PassThroughItem {
		private final PayerReceiverModel payerReceiverModel;
		private final AssetReference underlyerReference;
		private final BigDecimal passThroughPercentage;
		
		protected PassThroughItemImpl(PassThroughItem.PassThroughItemBuilder builder) {
			this.payerReceiverModel = ofNullable(builder.getPayerReceiverModel()).map(f->f.build()).orElse(null);
			this.underlyerReference = ofNullable(builder.getUnderlyerReference()).map(f->f.build()).orElse(null);
			this.passThroughPercentage = builder.getPassThroughPercentage();
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public AssetReference getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		@RosettaAttribute("passThroughPercentage")
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@Override
		public PassThroughItem build() {
			return this;
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			PassThroughItem.PassThroughItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PassThroughItem.PassThroughItemBuilder builder) {
			ofNullable(getPayerReceiverModel()).ifPresent(builder::setPayerReceiverModel);
			ofNullable(getUnderlyerReference()).ifPresent(builder::setUnderlyerReference);
			ofNullable(getPassThroughPercentage()).ifPresent(builder::setPassThroughPercentage);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItem {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"passThroughPercentage=" + this.passThroughPercentage +
			'}';
		}
	}

	/*********************** Builder Implementation of PassThroughItem  ***********************/
	class PassThroughItemBuilderImpl implements PassThroughItem.PassThroughItemBuilder {
	
		protected PayerReceiverModel.PayerReceiverModelBuilder payerReceiverModel;
		protected AssetReference.AssetReferenceBuilder underlyerReference;
		protected BigDecimal passThroughPercentage;
	
		public PassThroughItemBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PayerReceiverModel.PayerReceiverModelBuilder getPayerReceiverModel() {
			return payerReceiverModel;
		}
		
		@Override
		public PayerReceiverModel.PayerReceiverModelBuilder getOrCreatePayerReceiverModel() {
			PayerReceiverModel.PayerReceiverModelBuilder result;
			if (payerReceiverModel!=null) {
				result = payerReceiverModel;
			}
			else {
				result = payerReceiverModel = PayerReceiverModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyerReference")
		public AssetReference.AssetReferenceBuilder getUnderlyerReference() {
			return underlyerReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateUnderlyerReference() {
			AssetReference.AssetReferenceBuilder result;
			if (underlyerReference!=null) {
				result = underlyerReference;
			}
			else {
				result = underlyerReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("passThroughPercentage")
		public BigDecimal getPassThroughPercentage() {
			return passThroughPercentage;
		}
		
		@Override
		@RosettaAttribute("payerReceiverModel")
		public PassThroughItem.PassThroughItemBuilder setPayerReceiverModel(PayerReceiverModel payerReceiverModel) {
			this.payerReceiverModel = payerReceiverModel==null?null:payerReceiverModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("underlyerReference")
		public PassThroughItem.PassThroughItemBuilder setUnderlyerReference(AssetReference underlyerReference) {
			this.underlyerReference = underlyerReference==null?null:underlyerReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("passThroughPercentage")
		public PassThroughItem.PassThroughItemBuilder setPassThroughPercentage(BigDecimal passThroughPercentage) {
			this.passThroughPercentage = passThroughPercentage==null?null:passThroughPercentage;
			return this;
		}
		
		@Override
		public PassThroughItem build() {
			return new PassThroughItem.PassThroughItemImpl(this);
		}
		
		@Override
		public PassThroughItem.PassThroughItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder prune() {
			if (payerReceiverModel!=null && !payerReceiverModel.prune().hasData()) payerReceiverModel = null;
			if (underlyerReference!=null && !underlyerReference.prune().hasData()) underlyerReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayerReceiverModel()!=null && getPayerReceiverModel().hasData()) return true;
			if (getUnderlyerReference()!=null && getUnderlyerReference().hasData()) return true;
			if (getPassThroughPercentage()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PassThroughItem.PassThroughItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PassThroughItem.PassThroughItemBuilder o = (PassThroughItem.PassThroughItemBuilder) other;
			
			merger.mergeRosetta(getPayerReceiverModel(), o.getPayerReceiverModel(), this::setPayerReceiverModel);
			merger.mergeRosetta(getUnderlyerReference(), o.getUnderlyerReference(), this::setUnderlyerReference);
			
			merger.mergeBasic(getPassThroughPercentage(), o.getPassThroughPercentage(), this::setPassThroughPercentage);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PassThroughItem _that = getType().cast(o);
		
			if (!Objects.equals(payerReceiverModel, _that.getPayerReceiverModel())) return false;
			if (!Objects.equals(underlyerReference, _that.getUnderlyerReference())) return false;
			if (!Objects.equals(passThroughPercentage, _that.getPassThroughPercentage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payerReceiverModel != null ? payerReceiverModel.hashCode() : 0);
			_result = 31 * _result + (underlyerReference != null ? underlyerReference.hashCode() : 0);
			_result = 31 * _result + (passThroughPercentage != null ? passThroughPercentage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PassThroughItemBuilder {" +
				"payerReceiverModel=" + this.payerReceiverModel + ", " +
				"underlyerReference=" + this.underlyerReference + ", " +
				"passThroughPercentage=" + this.passThroughPercentage +
			'}';
		}
	}
}

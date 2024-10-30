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
import fpml.confirmation.AmountReference;
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.TradeLegFixedAmountChangeModel;
import fpml.confirmation.TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder;
import fpml.confirmation.TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilderImpl;
import fpml.confirmation.TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelImpl;
import fpml.confirmation.meta.TradeLegFixedAmountChangeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="TradeLegFixedAmountChangeModel", builder=TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface TradeLegFixedAmountChangeModel extends RosettaModelObject {

	TradeLegFixedAmountChangeModelMeta metaData = new TradeLegFixedAmountChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	AmountReference getKnownAmountReference();
	NonNegativeMoney getChangeInKnownAmount();
	NonNegativeMoney getOutstandingKnownAmount();

	/*********************** Build Methods  ***********************/
	TradeLegFixedAmountChangeModel build();
	
	TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder toBuilder();
	
	static TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder builder() {
		return new TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegFixedAmountChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegFixedAmountChangeModel> getType() {
		return TradeLegFixedAmountChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("knownAmountReference"), processor, AmountReference.class, getKnownAmountReference());
		processRosetta(path.newSubPath("changeInKnownAmount"), processor, NonNegativeMoney.class, getChangeInKnownAmount());
		processRosetta(path.newSubPath("outstandingKnownAmount"), processor, NonNegativeMoney.class, getOutstandingKnownAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegFixedAmountChangeModelBuilder extends TradeLegFixedAmountChangeModel, RosettaModelObjectBuilder {
		AmountReference.AmountReferenceBuilder getOrCreateKnownAmountReference();
		AmountReference.AmountReferenceBuilder getKnownAmountReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInKnownAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getChangeInKnownAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingKnownAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingKnownAmount();
		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setKnownAmountReference(AmountReference knownAmountReference);
		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setChangeInKnownAmount(NonNegativeMoney changeInKnownAmount);
		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setOutstandingKnownAmount(NonNegativeMoney outstandingKnownAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("knownAmountReference"), processor, AmountReference.AmountReferenceBuilder.class, getKnownAmountReference());
			processRosetta(path.newSubPath("changeInKnownAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInKnownAmount());
			processRosetta(path.newSubPath("outstandingKnownAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingKnownAmount());
		}
		

		TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegFixedAmountChangeModel  ***********************/
	class TradeLegFixedAmountChangeModelImpl implements TradeLegFixedAmountChangeModel {
		private final AmountReference knownAmountReference;
		private final NonNegativeMoney changeInKnownAmount;
		private final NonNegativeMoney outstandingKnownAmount;
		
		protected TradeLegFixedAmountChangeModelImpl(TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder builder) {
			this.knownAmountReference = ofNullable(builder.getKnownAmountReference()).map(f->f.build()).orElse(null);
			this.changeInKnownAmount = ofNullable(builder.getChangeInKnownAmount()).map(f->f.build()).orElse(null);
			this.outstandingKnownAmount = ofNullable(builder.getOutstandingKnownAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("knownAmountReference")
		public AmountReference getKnownAmountReference() {
			return knownAmountReference;
		}
		
		@Override
		@RosettaAttribute("changeInKnownAmount")
		public NonNegativeMoney getChangeInKnownAmount() {
			return changeInKnownAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingKnownAmount")
		public NonNegativeMoney getOutstandingKnownAmount() {
			return outstandingKnownAmount;
		}
		
		@Override
		public TradeLegFixedAmountChangeModel build() {
			return this;
		}
		
		@Override
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder toBuilder() {
			TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder builder) {
			ofNullable(getKnownAmountReference()).ifPresent(builder::setKnownAmountReference);
			ofNullable(getChangeInKnownAmount()).ifPresent(builder::setChangeInKnownAmount);
			ofNullable(getOutstandingKnownAmount()).ifPresent(builder::setOutstandingKnownAmount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegFixedAmountChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(knownAmountReference, _that.getKnownAmountReference())) return false;
			if (!Objects.equals(changeInKnownAmount, _that.getChangeInKnownAmount())) return false;
			if (!Objects.equals(outstandingKnownAmount, _that.getOutstandingKnownAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knownAmountReference != null ? knownAmountReference.hashCode() : 0);
			_result = 31 * _result + (changeInKnownAmount != null ? changeInKnownAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingKnownAmount != null ? outstandingKnownAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegFixedAmountChangeModel {" +
				"knownAmountReference=" + this.knownAmountReference + ", " +
				"changeInKnownAmount=" + this.changeInKnownAmount + ", " +
				"outstandingKnownAmount=" + this.outstandingKnownAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegFixedAmountChangeModel  ***********************/
	class TradeLegFixedAmountChangeModelBuilderImpl implements TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder {
	
		protected AmountReference.AmountReferenceBuilder knownAmountReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder changeInKnownAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder outstandingKnownAmount;
	
		public TradeLegFixedAmountChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("knownAmountReference")
		public AmountReference.AmountReferenceBuilder getKnownAmountReference() {
			return knownAmountReference;
		}
		
		@Override
		public AmountReference.AmountReferenceBuilder getOrCreateKnownAmountReference() {
			AmountReference.AmountReferenceBuilder result;
			if (knownAmountReference!=null) {
				result = knownAmountReference;
			}
			else {
				result = knownAmountReference = AmountReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInKnownAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getChangeInKnownAmount() {
			return changeInKnownAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInKnownAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (changeInKnownAmount!=null) {
				result = changeInKnownAmount;
			}
			else {
				result = changeInKnownAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingKnownAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingKnownAmount() {
			return outstandingKnownAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingKnownAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (outstandingKnownAmount!=null) {
				result = outstandingKnownAmount;
			}
			else {
				result = outstandingKnownAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("knownAmountReference")
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setKnownAmountReference(AmountReference knownAmountReference) {
			this.knownAmountReference = knownAmountReference==null?null:knownAmountReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeInKnownAmount")
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setChangeInKnownAmount(NonNegativeMoney changeInKnownAmount) {
			this.changeInKnownAmount = changeInKnownAmount==null?null:changeInKnownAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingKnownAmount")
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder setOutstandingKnownAmount(NonNegativeMoney outstandingKnownAmount) {
			this.outstandingKnownAmount = outstandingKnownAmount==null?null:outstandingKnownAmount.toBuilder();
			return this;
		}
		
		@Override
		public TradeLegFixedAmountChangeModel build() {
			return new TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelImpl(this);
		}
		
		@Override
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder prune() {
			if (knownAmountReference!=null && !knownAmountReference.prune().hasData()) knownAmountReference = null;
			if (changeInKnownAmount!=null && !changeInKnownAmount.prune().hasData()) changeInKnownAmount = null;
			if (outstandingKnownAmount!=null && !outstandingKnownAmount.prune().hasData()) outstandingKnownAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getKnownAmountReference()!=null && getKnownAmountReference().hasData()) return true;
			if (getChangeInKnownAmount()!=null && getChangeInKnownAmount().hasData()) return true;
			if (getOutstandingKnownAmount()!=null && getOutstandingKnownAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder o = (TradeLegFixedAmountChangeModel.TradeLegFixedAmountChangeModelBuilder) other;
			
			merger.mergeRosetta(getKnownAmountReference(), o.getKnownAmountReference(), this::setKnownAmountReference);
			merger.mergeRosetta(getChangeInKnownAmount(), o.getChangeInKnownAmount(), this::setChangeInKnownAmount);
			merger.mergeRosetta(getOutstandingKnownAmount(), o.getOutstandingKnownAmount(), this::setOutstandingKnownAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegFixedAmountChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(knownAmountReference, _that.getKnownAmountReference())) return false;
			if (!Objects.equals(changeInKnownAmount, _that.getChangeInKnownAmount())) return false;
			if (!Objects.equals(outstandingKnownAmount, _that.getOutstandingKnownAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (knownAmountReference != null ? knownAmountReference.hashCode() : 0);
			_result = 31 * _result + (changeInKnownAmount != null ? changeInKnownAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingKnownAmount != null ? outstandingKnownAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegFixedAmountChangeModelBuilder {" +
				"knownAmountReference=" + this.knownAmountReference + ", " +
				"changeInKnownAmount=" + this.changeInKnownAmount + ", " +
				"outstandingKnownAmount=" + this.outstandingKnownAmount +
			'}';
		}
	}
}

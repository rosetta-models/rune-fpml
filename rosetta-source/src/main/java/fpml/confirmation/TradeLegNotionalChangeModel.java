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
import fpml.confirmation.NonNegativeMoney;
import fpml.confirmation.NotionalReference;
import fpml.confirmation.TradeLegNotionalChangeModel;
import fpml.confirmation.TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder;
import fpml.confirmation.TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilderImpl;
import fpml.confirmation.TradeLegNotionalChangeModel.TradeLegNotionalChangeModelImpl;
import fpml.confirmation.meta.TradeLegNotionalChangeModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeLegNotionalChangeModel", builder=TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilderImpl.class, version="${project.version}")
public interface TradeLegNotionalChangeModel extends RosettaModelObject {

	TradeLegNotionalChangeModelMeta metaData = new TradeLegNotionalChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	NotionalReference getNotionalReference();
	NonNegativeMoney getChangeInNotionalAmount();
	NonNegativeMoney getOutstandingNotionalAmount();

	/*********************** Build Methods  ***********************/
	TradeLegNotionalChangeModel build();
	
	TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder toBuilder();
	
	static TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder builder() {
		return new TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegNotionalChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegNotionalChangeModel> getType() {
		return TradeLegNotionalChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.class, getNotionalReference());
		processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.class, getChangeInNotionalAmount());
		processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.class, getOutstandingNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegNotionalChangeModelBuilder extends TradeLegNotionalChangeModel, RosettaModelObjectBuilder {
		NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference();
		NotionalReference.NotionalReferenceBuilder getNotionalReference();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getChangeInNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount();
		NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingNotionalAmount();
		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setNotionalReference(NotionalReference notionalReference);
		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount);
		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("notionalReference"), processor, NotionalReference.NotionalReferenceBuilder.class, getNotionalReference());
			processRosetta(path.newSubPath("changeInNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getChangeInNotionalAmount());
			processRosetta(path.newSubPath("outstandingNotionalAmount"), processor, NonNegativeMoney.NonNegativeMoneyBuilder.class, getOutstandingNotionalAmount());
		}
		

		TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegNotionalChangeModel  ***********************/
	class TradeLegNotionalChangeModelImpl implements TradeLegNotionalChangeModel {
		private final NotionalReference notionalReference;
		private final NonNegativeMoney changeInNotionalAmount;
		private final NonNegativeMoney outstandingNotionalAmount;
		
		protected TradeLegNotionalChangeModelImpl(TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder builder) {
			this.notionalReference = ofNullable(builder.getNotionalReference()).map(f->f.build()).orElse(null);
			this.changeInNotionalAmount = ofNullable(builder.getChangeInNotionalAmount()).map(f->f.build()).orElse(null);
			this.outstandingNotionalAmount = ofNullable(builder.getOutstandingNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		public NonNegativeMoney getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public NonNegativeMoney getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public TradeLegNotionalChangeModel build() {
			return this;
		}
		
		@Override
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder toBuilder() {
			TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder builder) {
			ofNullable(getNotionalReference()).ifPresent(builder::setNotionalReference);
			ofNullable(getChangeInNotionalAmount()).ifPresent(builder::setChangeInNotionalAmount);
			ofNullable(getOutstandingNotionalAmount()).ifPresent(builder::setOutstandingNotionalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNotionalChangeModel {" +
				"notionalReference=" + this.notionalReference + ", " +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegNotionalChangeModel  ***********************/
	class TradeLegNotionalChangeModelBuilderImpl implements TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder {
	
		protected NotionalReference.NotionalReferenceBuilder notionalReference;
		protected NonNegativeMoney.NonNegativeMoneyBuilder changeInNotionalAmount;
		protected NonNegativeMoney.NonNegativeMoneyBuilder outstandingNotionalAmount;
	
		public TradeLegNotionalChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalReference")
		public NotionalReference.NotionalReferenceBuilder getNotionalReference() {
			return notionalReference;
		}
		
		@Override
		public NotionalReference.NotionalReferenceBuilder getOrCreateNotionalReference() {
			NotionalReference.NotionalReferenceBuilder result;
			if (notionalReference!=null) {
				result = notionalReference;
			}
			else {
				result = notionalReference = NotionalReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getChangeInNotionalAmount() {
			return changeInNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateChangeInNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (changeInNotionalAmount!=null) {
				result = changeInNotionalAmount;
			}
			else {
				result = changeInNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public NonNegativeMoney.NonNegativeMoneyBuilder getOutstandingNotionalAmount() {
			return outstandingNotionalAmount;
		}
		
		@Override
		public NonNegativeMoney.NonNegativeMoneyBuilder getOrCreateOutstandingNotionalAmount() {
			NonNegativeMoney.NonNegativeMoneyBuilder result;
			if (outstandingNotionalAmount!=null) {
				result = outstandingNotionalAmount;
			}
			else {
				result = outstandingNotionalAmount = NonNegativeMoney.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("notionalReference")
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setNotionalReference(NotionalReference notionalReference) {
			this.notionalReference = notionalReference==null?null:notionalReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeInNotionalAmount")
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setChangeInNotionalAmount(NonNegativeMoney changeInNotionalAmount) {
			this.changeInNotionalAmount = changeInNotionalAmount==null?null:changeInNotionalAmount.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNotionalAmount")
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder setOutstandingNotionalAmount(NonNegativeMoney outstandingNotionalAmount) {
			this.outstandingNotionalAmount = outstandingNotionalAmount==null?null:outstandingNotionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public TradeLegNotionalChangeModel build() {
			return new TradeLegNotionalChangeModel.TradeLegNotionalChangeModelImpl(this);
		}
		
		@Override
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder prune() {
			if (notionalReference!=null && !notionalReference.prune().hasData()) notionalReference = null;
			if (changeInNotionalAmount!=null && !changeInNotionalAmount.prune().hasData()) changeInNotionalAmount = null;
			if (outstandingNotionalAmount!=null && !outstandingNotionalAmount.prune().hasData()) outstandingNotionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalReference()!=null && getNotionalReference().hasData()) return true;
			if (getChangeInNotionalAmount()!=null && getChangeInNotionalAmount().hasData()) return true;
			if (getOutstandingNotionalAmount()!=null && getOutstandingNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder o = (TradeLegNotionalChangeModel.TradeLegNotionalChangeModelBuilder) other;
			
			merger.mergeRosetta(getNotionalReference(), o.getNotionalReference(), this::setNotionalReference);
			merger.mergeRosetta(getChangeInNotionalAmount(), o.getChangeInNotionalAmount(), this::setChangeInNotionalAmount);
			merger.mergeRosetta(getOutstandingNotionalAmount(), o.getOutstandingNotionalAmount(), this::setOutstandingNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNotionalChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(notionalReference, _that.getNotionalReference())) return false;
			if (!Objects.equals(changeInNotionalAmount, _that.getChangeInNotionalAmount())) return false;
			if (!Objects.equals(outstandingNotionalAmount, _that.getOutstandingNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalReference != null ? notionalReference.hashCode() : 0);
			_result = 31 * _result + (changeInNotionalAmount != null ? changeInNotionalAmount.hashCode() : 0);
			_result = 31 * _result + (outstandingNotionalAmount != null ? outstandingNotionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNotionalChangeModelBuilder {" +
				"notionalReference=" + this.notionalReference + ", " +
				"changeInNotionalAmount=" + this.changeInNotionalAmount + ", " +
				"outstandingNotionalAmount=" + this.outstandingNotionalAmount +
			'}';
		}
	}
}

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
import fpml.confirmation.NumberOfUnitsReference;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilderImpl;
import fpml.confirmation.TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelImpl;
import fpml.confirmation.meta.TradeLegNumberOfUnitsChangeModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeLegNumberOfUnitsChangeModel", builder=TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilderImpl.class, version="${project.version}")
public interface TradeLegNumberOfUnitsChangeModel extends RosettaModelObject {

	TradeLegNumberOfUnitsChangeModelMeta metaData = new TradeLegNumberOfUnitsChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	NumberOfUnitsReference getNumberOfUnitsReference();
	BigDecimal getChangeInNumberOfUnits();
	BigDecimal getOutstandingNumberOfUnits();

	/*********************** Build Methods  ***********************/
	TradeLegNumberOfUnitsChangeModel build();
	
	TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder toBuilder();
	
	static TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder builder() {
		return new TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegNumberOfUnitsChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegNumberOfUnitsChangeModel> getType() {
		return TradeLegNumberOfUnitsChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.class, getNumberOfUnitsReference());
		processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegNumberOfUnitsChangeModelBuilder extends TradeLegNumberOfUnitsChangeModel, RosettaModelObjectBuilder {
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference();
		NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference();
		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference);
		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits);
		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("numberOfUnitsReference"), processor, NumberOfUnitsReference.NumberOfUnitsReferenceBuilder.class, getNumberOfUnitsReference());
			processor.processBasic(path.newSubPath("changeInNumberOfUnits"), BigDecimal.class, getChangeInNumberOfUnits(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfUnits"), BigDecimal.class, getOutstandingNumberOfUnits(), this);
		}
		

		TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegNumberOfUnitsChangeModel  ***********************/
	class TradeLegNumberOfUnitsChangeModelImpl implements TradeLegNumberOfUnitsChangeModel {
		private final NumberOfUnitsReference numberOfUnitsReference;
		private final BigDecimal changeInNumberOfUnits;
		private final BigDecimal outstandingNumberOfUnits;
		
		protected TradeLegNumberOfUnitsChangeModelImpl(TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder builder) {
			this.numberOfUnitsReference = ofNullable(builder.getNumberOfUnitsReference()).map(f->f.build()).orElse(null);
			this.changeInNumberOfUnits = builder.getChangeInNumberOfUnits();
			this.outstandingNumberOfUnits = builder.getOutstandingNumberOfUnits();
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		public TradeLegNumberOfUnitsChangeModel build() {
			return this;
		}
		
		@Override
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder toBuilder() {
			TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder builder) {
			ofNullable(getNumberOfUnitsReference()).ifPresent(builder::setNumberOfUnitsReference);
			ofNullable(getChangeInNumberOfUnits()).ifPresent(builder::setChangeInNumberOfUnits);
			ofNullable(getOutstandingNumberOfUnits()).ifPresent(builder::setOutstandingNumberOfUnits);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNumberOfUnitsChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNumberOfUnitsChangeModel {" +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegNumberOfUnitsChangeModel  ***********************/
	class TradeLegNumberOfUnitsChangeModelBuilderImpl implements TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder {
	
		protected NumberOfUnitsReference.NumberOfUnitsReferenceBuilder numberOfUnitsReference;
		protected BigDecimal changeInNumberOfUnits;
		protected BigDecimal outstandingNumberOfUnits;
	
		public TradeLegNumberOfUnitsChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getNumberOfUnitsReference() {
			return numberOfUnitsReference;
		}
		
		@Override
		public NumberOfUnitsReference.NumberOfUnitsReferenceBuilder getOrCreateNumberOfUnitsReference() {
			NumberOfUnitsReference.NumberOfUnitsReferenceBuilder result;
			if (numberOfUnitsReference!=null) {
				result = numberOfUnitsReference;
			}
			else {
				result = numberOfUnitsReference = NumberOfUnitsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public BigDecimal getChangeInNumberOfUnits() {
			return changeInNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public BigDecimal getOutstandingNumberOfUnits() {
			return outstandingNumberOfUnits;
		}
		
		@Override
		@RosettaAttribute("numberOfUnitsReference")
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setNumberOfUnitsReference(NumberOfUnitsReference numberOfUnitsReference) {
			this.numberOfUnitsReference = numberOfUnitsReference==null?null:numberOfUnitsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeInNumberOfUnits")
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setChangeInNumberOfUnits(BigDecimal changeInNumberOfUnits) {
			this.changeInNumberOfUnits = changeInNumberOfUnits==null?null:changeInNumberOfUnits;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfUnits")
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder setOutstandingNumberOfUnits(BigDecimal outstandingNumberOfUnits) {
			this.outstandingNumberOfUnits = outstandingNumberOfUnits==null?null:outstandingNumberOfUnits;
			return this;
		}
		
		@Override
		public TradeLegNumberOfUnitsChangeModel build() {
			return new TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelImpl(this);
		}
		
		@Override
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder prune() {
			if (numberOfUnitsReference!=null && !numberOfUnitsReference.prune().hasData()) numberOfUnitsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfUnitsReference()!=null && getNumberOfUnitsReference().hasData()) return true;
			if (getChangeInNumberOfUnits()!=null) return true;
			if (getOutstandingNumberOfUnits()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder o = (TradeLegNumberOfUnitsChangeModel.TradeLegNumberOfUnitsChangeModelBuilder) other;
			
			merger.mergeRosetta(getNumberOfUnitsReference(), o.getNumberOfUnitsReference(), this::setNumberOfUnitsReference);
			
			merger.mergeBasic(getChangeInNumberOfUnits(), o.getChangeInNumberOfUnits(), this::setChangeInNumberOfUnits);
			merger.mergeBasic(getOutstandingNumberOfUnits(), o.getOutstandingNumberOfUnits(), this::setOutstandingNumberOfUnits);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNumberOfUnitsChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfUnitsReference, _that.getNumberOfUnitsReference())) return false;
			if (!Objects.equals(changeInNumberOfUnits, _that.getChangeInNumberOfUnits())) return false;
			if (!Objects.equals(outstandingNumberOfUnits, _that.getOutstandingNumberOfUnits())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfUnitsReference != null ? numberOfUnitsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfUnits != null ? changeInNumberOfUnits.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfUnits != null ? outstandingNumberOfUnits.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNumberOfUnitsChangeModelBuilder {" +
				"numberOfUnitsReference=" + this.numberOfUnitsReference + ", " +
				"changeInNumberOfUnits=" + this.changeInNumberOfUnits + ", " +
				"outstandingNumberOfUnits=" + this.outstandingNumberOfUnits +
			'}';
		}
	}
}

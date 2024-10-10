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
import fpml.confirmation.NumberOfOptionsReference;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilderImpl;
import fpml.confirmation.TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelImpl;
import fpml.confirmation.meta.TradeLegNumberOfOptionsChangeModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="TradeLegNumberOfOptionsChangeModel", builder=TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilderImpl.class, version="${project.version}")
public interface TradeLegNumberOfOptionsChangeModel extends RosettaModelObject {

	TradeLegNumberOfOptionsChangeModelMeta metaData = new TradeLegNumberOfOptionsChangeModelMeta();

	/*********************** Getter Methods  ***********************/
	NumberOfOptionsReference getNumberOfOptionsReference();
	BigDecimal getChangeInNumberOfOptions();
	BigDecimal getOutstandingNumberOfOptions();

	/*********************** Build Methods  ***********************/
	TradeLegNumberOfOptionsChangeModel build();
	
	TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder toBuilder();
	
	static TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder builder() {
		return new TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends TradeLegNumberOfOptionsChangeModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends TradeLegNumberOfOptionsChangeModel> getType() {
		return TradeLegNumberOfOptionsChangeModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.class, getNumberOfOptionsReference());
		processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
		processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface TradeLegNumberOfOptionsChangeModelBuilder extends TradeLegNumberOfOptionsChangeModel, RosettaModelObjectBuilder {
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference();
		NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference();
		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference);
		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions);
		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("numberOfOptionsReference"), processor, NumberOfOptionsReference.NumberOfOptionsReferenceBuilder.class, getNumberOfOptionsReference());
			processor.processBasic(path.newSubPath("changeInNumberOfOptions"), BigDecimal.class, getChangeInNumberOfOptions(), this);
			processor.processBasic(path.newSubPath("outstandingNumberOfOptions"), BigDecimal.class, getOutstandingNumberOfOptions(), this);
		}
		

		TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder prune();
	}

	/*********************** Immutable Implementation of TradeLegNumberOfOptionsChangeModel  ***********************/
	class TradeLegNumberOfOptionsChangeModelImpl implements TradeLegNumberOfOptionsChangeModel {
		private final NumberOfOptionsReference numberOfOptionsReference;
		private final BigDecimal changeInNumberOfOptions;
		private final BigDecimal outstandingNumberOfOptions;
		
		protected TradeLegNumberOfOptionsChangeModelImpl(TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder builder) {
			this.numberOfOptionsReference = ofNullable(builder.getNumberOfOptionsReference()).map(f->f.build()).orElse(null);
			this.changeInNumberOfOptions = builder.getChangeInNumberOfOptions();
			this.outstandingNumberOfOptions = builder.getOutstandingNumberOfOptions();
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		public TradeLegNumberOfOptionsChangeModel build() {
			return this;
		}
		
		@Override
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder toBuilder() {
			TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder builder) {
			ofNullable(getNumberOfOptionsReference()).ifPresent(builder::setNumberOfOptionsReference);
			ofNullable(getChangeInNumberOfOptions()).ifPresent(builder::setChangeInNumberOfOptions);
			ofNullable(getOutstandingNumberOfOptions()).ifPresent(builder::setOutstandingNumberOfOptions);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNumberOfOptionsChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNumberOfOptionsChangeModel {" +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}

	/*********************** Builder Implementation of TradeLegNumberOfOptionsChangeModel  ***********************/
	class TradeLegNumberOfOptionsChangeModelBuilderImpl implements TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder {
	
		protected NumberOfOptionsReference.NumberOfOptionsReferenceBuilder numberOfOptionsReference;
		protected BigDecimal changeInNumberOfOptions;
		protected BigDecimal outstandingNumberOfOptions;
	
		public TradeLegNumberOfOptionsChangeModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getNumberOfOptionsReference() {
			return numberOfOptionsReference;
		}
		
		@Override
		public NumberOfOptionsReference.NumberOfOptionsReferenceBuilder getOrCreateNumberOfOptionsReference() {
			NumberOfOptionsReference.NumberOfOptionsReferenceBuilder result;
			if (numberOfOptionsReference!=null) {
				result = numberOfOptionsReference;
			}
			else {
				result = numberOfOptionsReference = NumberOfOptionsReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public BigDecimal getChangeInNumberOfOptions() {
			return changeInNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public BigDecimal getOutstandingNumberOfOptions() {
			return outstandingNumberOfOptions;
		}
		
		@Override
		@RosettaAttribute("numberOfOptionsReference")
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setNumberOfOptionsReference(NumberOfOptionsReference numberOfOptionsReference) {
			this.numberOfOptionsReference = numberOfOptionsReference==null?null:numberOfOptionsReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("changeInNumberOfOptions")
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setChangeInNumberOfOptions(BigDecimal changeInNumberOfOptions) {
			this.changeInNumberOfOptions = changeInNumberOfOptions==null?null:changeInNumberOfOptions;
			return this;
		}
		@Override
		@RosettaAttribute("outstandingNumberOfOptions")
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder setOutstandingNumberOfOptions(BigDecimal outstandingNumberOfOptions) {
			this.outstandingNumberOfOptions = outstandingNumberOfOptions==null?null:outstandingNumberOfOptions;
			return this;
		}
		
		@Override
		public TradeLegNumberOfOptionsChangeModel build() {
			return new TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelImpl(this);
		}
		
		@Override
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder prune() {
			if (numberOfOptionsReference!=null && !numberOfOptionsReference.prune().hasData()) numberOfOptionsReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNumberOfOptionsReference()!=null && getNumberOfOptionsReference().hasData()) return true;
			if (getChangeInNumberOfOptions()!=null) return true;
			if (getOutstandingNumberOfOptions()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder o = (TradeLegNumberOfOptionsChangeModel.TradeLegNumberOfOptionsChangeModelBuilder) other;
			
			merger.mergeRosetta(getNumberOfOptionsReference(), o.getNumberOfOptionsReference(), this::setNumberOfOptionsReference);
			
			merger.mergeBasic(getChangeInNumberOfOptions(), o.getChangeInNumberOfOptions(), this::setChangeInNumberOfOptions);
			merger.mergeBasic(getOutstandingNumberOfOptions(), o.getOutstandingNumberOfOptions(), this::setOutstandingNumberOfOptions);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			TradeLegNumberOfOptionsChangeModel _that = getType().cast(o);
		
			if (!Objects.equals(numberOfOptionsReference, _that.getNumberOfOptionsReference())) return false;
			if (!Objects.equals(changeInNumberOfOptions, _that.getChangeInNumberOfOptions())) return false;
			if (!Objects.equals(outstandingNumberOfOptions, _that.getOutstandingNumberOfOptions())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (numberOfOptionsReference != null ? numberOfOptionsReference.hashCode() : 0);
			_result = 31 * _result + (changeInNumberOfOptions != null ? changeInNumberOfOptions.hashCode() : 0);
			_result = 31 * _result + (outstandingNumberOfOptions != null ? outstandingNumberOfOptions.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "TradeLegNumberOfOptionsChangeModelBuilder {" +
				"numberOfOptionsReference=" + this.numberOfOptionsReference + ", " +
				"changeInNumberOfOptions=" + this.changeInNumberOfOptions + ", " +
				"outstandingNumberOfOptions=" + this.outstandingNumberOfOptions +
			'}';
		}
	}
}

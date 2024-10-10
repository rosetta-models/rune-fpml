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
import fpml.confirmation.PeriodModel;
import fpml.confirmation.PeriodWithDaysModel;
import fpml.confirmation.PeriodWithDaysModel.PeriodWithDaysModelBuilder;
import fpml.confirmation.PeriodWithDaysModel.PeriodWithDaysModelBuilderImpl;
import fpml.confirmation.PeriodWithDaysModel.PeriodWithDaysModelImpl;
import fpml.confirmation.meta.PeriodWithDaysModelMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A model that describes a period, with an element to define number of days within the period.
 * @version ${project.version}
 */
@RosettaDataType(value="PeriodWithDaysModel", builder=PeriodWithDaysModel.PeriodWithDaysModelBuilderImpl.class, version="${project.version}")
public interface PeriodWithDaysModel extends RosettaModelObject {

	PeriodWithDaysModelMeta metaData = new PeriodWithDaysModelMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * The actual number of days represented within the &#39;period&#39;. This takes into account counting the appropriate convention.
	 */
	BigDecimal getNumberOfDays();

	/*********************** Build Methods  ***********************/
	PeriodWithDaysModel build();
	
	PeriodWithDaysModel.PeriodWithDaysModelBuilder toBuilder();
	
	static PeriodWithDaysModel.PeriodWithDaysModelBuilder builder() {
		return new PeriodWithDaysModel.PeriodWithDaysModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PeriodWithDaysModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PeriodWithDaysModel> getType() {
		return PeriodWithDaysModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processor.processBasic(path.newSubPath("numberOfDays"), BigDecimal.class, getNumberOfDays(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface PeriodWithDaysModelBuilder extends PeriodWithDaysModel, RosettaModelObjectBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		PeriodWithDaysModel.PeriodWithDaysModelBuilder setPeriodModel(PeriodModel periodModel);
		PeriodWithDaysModel.PeriodWithDaysModelBuilder setNumberOfDays(BigDecimal numberOfDays);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processor.processBasic(path.newSubPath("numberOfDays"), BigDecimal.class, getNumberOfDays(), this);
		}
		

		PeriodWithDaysModel.PeriodWithDaysModelBuilder prune();
	}

	/*********************** Immutable Implementation of PeriodWithDaysModel  ***********************/
	class PeriodWithDaysModelImpl implements PeriodWithDaysModel {
		private final PeriodModel periodModel;
		private final BigDecimal numberOfDays;
		
		protected PeriodWithDaysModelImpl(PeriodWithDaysModel.PeriodWithDaysModelBuilder builder) {
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.numberOfDays = builder.getNumberOfDays();
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		public BigDecimal getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		public PeriodWithDaysModel build() {
			return this;
		}
		
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder toBuilder() {
			PeriodWithDaysModel.PeriodWithDaysModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PeriodWithDaysModel.PeriodWithDaysModelBuilder builder) {
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getNumberOfDays()).ifPresent(builder::setNumberOfDays);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodWithDaysModel _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodWithDaysModel {" +
				"periodModel=" + this.periodModel + ", " +
				"numberOfDays=" + this.numberOfDays +
			'}';
		}
	}

	/*********************** Builder Implementation of PeriodWithDaysModel  ***********************/
	class PeriodWithDaysModelBuilderImpl implements PeriodWithDaysModel.PeriodWithDaysModelBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected BigDecimal numberOfDays;
	
		public PeriodWithDaysModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel.PeriodModelBuilder getPeriodModel() {
			return periodModel;
		}
		
		@Override
		public PeriodModel.PeriodModelBuilder getOrCreatePeriodModel() {
			PeriodModel.PeriodModelBuilder result;
			if (periodModel!=null) {
				result = periodModel;
			}
			else {
				result = periodModel = PeriodModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("numberOfDays")
		public BigDecimal getNumberOfDays() {
			return numberOfDays;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("numberOfDays")
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder setNumberOfDays(BigDecimal numberOfDays) {
			this.numberOfDays = numberOfDays==null?null:numberOfDays;
			return this;
		}
		
		@Override
		public PeriodWithDaysModel build() {
			return new PeriodWithDaysModel.PeriodWithDaysModelImpl(this);
		}
		
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder prune() {
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getNumberOfDays()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PeriodWithDaysModel.PeriodWithDaysModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PeriodWithDaysModel.PeriodWithDaysModelBuilder o = (PeriodWithDaysModel.PeriodWithDaysModelBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			
			merger.mergeBasic(getNumberOfDays(), o.getNumberOfDays(), this::setNumberOfDays);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PeriodWithDaysModel _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(numberOfDays, _that.getNumberOfDays())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (numberOfDays != null ? numberOfDays.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PeriodWithDaysModelBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"numberOfDays=" + this.numberOfDays +
			'}';
		}
	}
}

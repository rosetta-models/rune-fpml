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
import fpml.confirmation.LoanAllocationNoSettlePeriod;
import fpml.confirmation.LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder;
import fpml.confirmation.LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl;
import fpml.confirmation.LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodImpl;
import fpml.confirmation.LoanAllocationNoSettlePeriodType;
import fpml.confirmation.PeriodModel;
import fpml.confirmation.meta.LoanAllocationNoSettlePeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that describes a period during which settlement cannot occur.
 * @version ${project.version}
 */
@RosettaDataType(value="LoanAllocationNoSettlePeriod", builder=LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl.class, version="${project.version}")
public interface LoanAllocationNoSettlePeriod extends RosettaModelObject {

	LoanAllocationNoSettlePeriodMeta metaData = new LoanAllocationNoSettlePeriodMeta();

	/*********************** Getter Methods  ***********************/
	PeriodModel getPeriodModel();
	/**
	 * A list of allowable types of no-settle periods.
	 */
	LoanAllocationNoSettlePeriodType getPeriodType();

	/*********************** Build Methods  ***********************/
	LoanAllocationNoSettlePeriod build();
	
	LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder();
	
	static LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder() {
		return new LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationNoSettlePeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanAllocationNoSettlePeriod> getType() {
		return LoanAllocationNoSettlePeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.class, getPeriodModel());
		processRosetta(path.newSubPath("periodType"), processor, LoanAllocationNoSettlePeriodType.class, getPeriodType());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationNoSettlePeriodBuilder extends LoanAllocationNoSettlePeriod, RosettaModelObjectBuilder {
		PeriodModel.PeriodModelBuilder getOrCreatePeriodModel();
		PeriodModel.PeriodModelBuilder getPeriodModel();
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getOrCreatePeriodType();
		LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getPeriodType();
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodModel(PeriodModel periodModel);
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodType(LoanAllocationNoSettlePeriodType periodType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("periodModel"), processor, PeriodModel.PeriodModelBuilder.class, getPeriodModel());
			processRosetta(path.newSubPath("periodType"), processor, LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder.class, getPeriodType());
		}
		

		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationNoSettlePeriod  ***********************/
	class LoanAllocationNoSettlePeriodImpl implements LoanAllocationNoSettlePeriod {
		private final PeriodModel periodModel;
		private final LoanAllocationNoSettlePeriodType periodType;
		
		protected LoanAllocationNoSettlePeriodImpl(LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder) {
			this.periodModel = ofNullable(builder.getPeriodModel()).map(f->f.build()).orElse(null);
			this.periodType = ofNullable(builder.getPeriodType()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public PeriodModel getPeriodModel() {
			return periodModel;
		}
		
		@Override
		@RosettaAttribute("periodType")
		public LoanAllocationNoSettlePeriodType getPeriodType() {
			return periodType;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod build() {
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder() {
			LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder builder) {
			ofNullable(getPeriodModel()).ifPresent(builder::setPeriodModel);
			ofNullable(getPeriodType()).ifPresent(builder::setPeriodType);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(periodType, _that.getPeriodType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (periodType != null ? periodType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriod {" +
				"periodModel=" + this.periodModel + ", " +
				"periodType=" + this.periodType +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanAllocationNoSettlePeriod  ***********************/
	class LoanAllocationNoSettlePeriodBuilderImpl implements LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder {
	
		protected PeriodModel.PeriodModelBuilder periodModel;
		protected LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder periodType;
	
		public LoanAllocationNoSettlePeriodBuilderImpl() {
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
		@RosettaAttribute("periodType")
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getPeriodType() {
			return periodType;
		}
		
		@Override
		public LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder getOrCreatePeriodType() {
			LoanAllocationNoSettlePeriodType.LoanAllocationNoSettlePeriodTypeBuilder result;
			if (periodType!=null) {
				result = periodType;
			}
			else {
				result = periodType = LoanAllocationNoSettlePeriodType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodModel")
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodModel(PeriodModel periodModel) {
			this.periodModel = periodModel==null?null:periodModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodType")
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder setPeriodType(LoanAllocationNoSettlePeriodType periodType) {
			this.periodType = periodType==null?null:periodType.toBuilder();
			return this;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod build() {
			return new LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodImpl(this);
		}
		
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder prune() {
			if (periodModel!=null && !periodModel.prune().hasData()) periodModel = null;
			if (periodType!=null && !periodType.prune().hasData()) periodType = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPeriodModel()!=null && getPeriodModel().hasData()) return true;
			if (getPeriodType()!=null && getPeriodType().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder o = (LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder) other;
			
			merger.mergeRosetta(getPeriodModel(), o.getPeriodModel(), this::setPeriodModel);
			merger.mergeRosetta(getPeriodType(), o.getPeriodType(), this::setPeriodType);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanAllocationNoSettlePeriod _that = getType().cast(o);
		
			if (!Objects.equals(periodModel, _that.getPeriodModel())) return false;
			if (!Objects.equals(periodType, _that.getPeriodType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (periodModel != null ? periodModel.hashCode() : 0);
			_result = 31 * _result + (periodType != null ? periodType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationNoSettlePeriodBuilder {" +
				"periodModel=" + this.periodModel + ", " +
				"periodType=" + this.periodType +
			'}';
		}
	}
}

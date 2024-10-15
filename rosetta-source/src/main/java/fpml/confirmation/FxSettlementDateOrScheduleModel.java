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
import fpml.confirmation.FxAdjustedDateAndDateAdjustments;
import fpml.confirmation.FxSettlementDateOrScheduleModel;
import fpml.confirmation.FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder;
import fpml.confirmation.FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilderImpl;
import fpml.confirmation.FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelImpl;
import fpml.confirmation.FxSettlementSchedule;
import fpml.confirmation.meta.FxSettlementDateOrScheduleModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the settlement/payment date or schedule of the accrual product.
 * @version ${project.version}
 */
@RosettaDataType(value="FxSettlementDateOrScheduleModel", builder=FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilderImpl.class, version="${project.version}")
public interface FxSettlementDateOrScheduleModel extends RosettaModelObject {

	FxSettlementDateOrScheduleModelMeta metaData = new FxSettlementDateOrScheduleModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The date on which settlement takes place for a settlement period.
	 */
	FxAdjustedDateAndDateAdjustments getSettlementDate();
	/**
	 * The parameters for defining a schedule of settlement periods for a accrual forward FX transaction.
	 */
	FxSettlementSchedule getSettlementSchedule();

	/*********************** Build Methods  ***********************/
	FxSettlementDateOrScheduleModel build();
	
	FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder toBuilder();
	
	static FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder builder() {
		return new FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSettlementDateOrScheduleModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSettlementDateOrScheduleModel> getType() {
		return FxSettlementDateOrScheduleModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.class, getSettlementDate());
		processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.class, getSettlementSchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxSettlementDateOrScheduleModelBuilder extends FxSettlementDateOrScheduleModel, RosettaModelObjectBuilder {
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate();
		FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate();
		FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule();
		FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule();
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate);
		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("settlementDate"), processor, FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder.class, getSettlementDate());
			processRosetta(path.newSubPath("settlementSchedule"), processor, FxSettlementSchedule.FxSettlementScheduleBuilder.class, getSettlementSchedule());
		}
		

		FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxSettlementDateOrScheduleModel  ***********************/
	class FxSettlementDateOrScheduleModelImpl implements FxSettlementDateOrScheduleModel {
		private final FxAdjustedDateAndDateAdjustments settlementDate;
		private final FxSettlementSchedule settlementSchedule;
		
		protected FxSettlementDateOrScheduleModelImpl(FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder builder) {
			this.settlementDate = ofNullable(builder.getSettlementDate()).map(f->f.build()).orElse(null);
			this.settlementSchedule = ofNullable(builder.getSettlementSchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxSettlementSchedule getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel build() {
			return this;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder toBuilder() {
			FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder builder) {
			ofNullable(getSettlementDate()).ifPresent(builder::setSettlementDate);
			ofNullable(getSettlementSchedule()).ifPresent(builder::setSettlementSchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementDateOrScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementDateOrScheduleModel {" +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSettlementDateOrScheduleModel  ***********************/
	class FxSettlementDateOrScheduleModelBuilderImpl implements FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder {
	
		protected FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder settlementDate;
		protected FxSettlementSchedule.FxSettlementScheduleBuilder settlementSchedule;
	
		public FxSettlementDateOrScheduleModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("settlementDate")
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getSettlementDate() {
			return settlementDate;
		}
		
		@Override
		public FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder getOrCreateSettlementDate() {
			FxAdjustedDateAndDateAdjustments.FxAdjustedDateAndDateAdjustmentsBuilder result;
			if (settlementDate!=null) {
				result = settlementDate;
			}
			else {
				result = settlementDate = FxAdjustedDateAndDateAdjustments.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxSettlementSchedule.FxSettlementScheduleBuilder getSettlementSchedule() {
			return settlementSchedule;
		}
		
		@Override
		public FxSettlementSchedule.FxSettlementScheduleBuilder getOrCreateSettlementSchedule() {
			FxSettlementSchedule.FxSettlementScheduleBuilder result;
			if (settlementSchedule!=null) {
				result = settlementSchedule;
			}
			else {
				result = settlementSchedule = FxSettlementSchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("settlementDate")
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder setSettlementDate(FxAdjustedDateAndDateAdjustments settlementDate) {
			this.settlementDate = settlementDate==null?null:settlementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("settlementSchedule")
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder setSettlementSchedule(FxSettlementSchedule settlementSchedule) {
			this.settlementSchedule = settlementSchedule==null?null:settlementSchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxSettlementDateOrScheduleModel build() {
			return new FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelImpl(this);
		}
		
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder prune() {
			if (settlementDate!=null && !settlementDate.prune().hasData()) settlementDate = null;
			if (settlementSchedule!=null && !settlementSchedule.prune().hasData()) settlementSchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSettlementDate()!=null && getSettlementDate().hasData()) return true;
			if (getSettlementSchedule()!=null && getSettlementSchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder o = (FxSettlementDateOrScheduleModel.FxSettlementDateOrScheduleModelBuilder) other;
			
			merger.mergeRosetta(getSettlementDate(), o.getSettlementDate(), this::setSettlementDate);
			merger.mergeRosetta(getSettlementSchedule(), o.getSettlementSchedule(), this::setSettlementSchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSettlementDateOrScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(settlementDate, _that.getSettlementDate())) return false;
			if (!Objects.equals(settlementSchedule, _that.getSettlementSchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (settlementDate != null ? settlementDate.hashCode() : 0);
			_result = 31 * _result + (settlementSchedule != null ? settlementSchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSettlementDateOrScheduleModelBuilder {" +
				"settlementDate=" + this.settlementDate + ", " +
				"settlementSchedule=" + this.settlementSchedule +
			'}';
		}
	}
}

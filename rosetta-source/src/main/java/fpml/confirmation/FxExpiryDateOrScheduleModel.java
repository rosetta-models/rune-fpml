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
import fpml.confirmation.FxExpiryDate;
import fpml.confirmation.FxExpiryDateOrScheduleModel;
import fpml.confirmation.FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder;
import fpml.confirmation.FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilderImpl;
import fpml.confirmation.FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelImpl;
import fpml.confirmation.FxExpirySchedule;
import fpml.confirmation.meta.FxExpiryDateOrScheduleModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the expiry/observation date or schedule of the accrual product.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxExpiryDateOrScheduleModel", builder=FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxExpiryDateOrScheduleModel extends RosettaModelObject {

	FxExpiryDateOrScheduleModelMeta metaData = new FxExpiryDateOrScheduleModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the expiry of a single period accrual forward FX transaction.
	 */
	FxExpiryDate getExpiryDate();
	/**
	 * The parameters for defining a schedule of expiry periods for an accrual forward FX transaction.
	 */
	FxExpirySchedule getExpirySchedule();

	/*********************** Build Methods  ***********************/
	FxExpiryDateOrScheduleModel build();
	
	FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder toBuilder();
	
	static FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder builder() {
		return new FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxExpiryDateOrScheduleModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxExpiryDateOrScheduleModel> getType() {
		return FxExpiryDateOrScheduleModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.class, getExpiryDate());
		processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.class, getExpirySchedule());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxExpiryDateOrScheduleModelBuilder extends FxExpiryDateOrScheduleModel, RosettaModelObjectBuilder {
		FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate();
		FxExpiryDate.FxExpiryDateBuilder getExpiryDate();
		FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule();
		FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule();
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder setExpiryDate(FxExpiryDate expiryDate);
		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder setExpirySchedule(FxExpirySchedule expirySchedule);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("expiryDate"), processor, FxExpiryDate.FxExpiryDateBuilder.class, getExpiryDate());
			processRosetta(path.newSubPath("expirySchedule"), processor, FxExpirySchedule.FxExpiryScheduleBuilder.class, getExpirySchedule());
		}
		

		FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxExpiryDateOrScheduleModel  ***********************/
	class FxExpiryDateOrScheduleModelImpl implements FxExpiryDateOrScheduleModel {
		private final FxExpiryDate expiryDate;
		private final FxExpirySchedule expirySchedule;
		
		protected FxExpiryDateOrScheduleModelImpl(FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder builder) {
			this.expiryDate = ofNullable(builder.getExpiryDate()).map(f->f.build()).orElse(null);
			this.expirySchedule = ofNullable(builder.getExpirySchedule()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public FxExpiryDate getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		public FxExpirySchedule getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel build() {
			return this;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder toBuilder() {
			FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder builder) {
			ofNullable(getExpiryDate()).ifPresent(builder::setExpiryDate);
			ofNullable(getExpirySchedule()).ifPresent(builder::setExpirySchedule);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExpiryDateOrScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDateOrScheduleModel {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule +
			'}';
		}
	}

	/*********************** Builder Implementation of FxExpiryDateOrScheduleModel  ***********************/
	class FxExpiryDateOrScheduleModelBuilderImpl implements FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder {
	
		protected FxExpiryDate.FxExpiryDateBuilder expiryDate;
		protected FxExpirySchedule.FxExpiryScheduleBuilder expirySchedule;
	
		public FxExpiryDateOrScheduleModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("expiryDate")
		public FxExpiryDate.FxExpiryDateBuilder getExpiryDate() {
			return expiryDate;
		}
		
		@Override
		public FxExpiryDate.FxExpiryDateBuilder getOrCreateExpiryDate() {
			FxExpiryDate.FxExpiryDateBuilder result;
			if (expiryDate!=null) {
				result = expiryDate;
			}
			else {
				result = expiryDate = FxExpiryDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirySchedule")
		public FxExpirySchedule.FxExpiryScheduleBuilder getExpirySchedule() {
			return expirySchedule;
		}
		
		@Override
		public FxExpirySchedule.FxExpiryScheduleBuilder getOrCreateExpirySchedule() {
			FxExpirySchedule.FxExpiryScheduleBuilder result;
			if (expirySchedule!=null) {
				result = expirySchedule;
			}
			else {
				result = expirySchedule = FxExpirySchedule.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expiryDate")
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder setExpiryDate(FxExpiryDate expiryDate) {
			this.expiryDate = expiryDate==null?null:expiryDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirySchedule")
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder setExpirySchedule(FxExpirySchedule expirySchedule) {
			this.expirySchedule = expirySchedule==null?null:expirySchedule.toBuilder();
			return this;
		}
		
		@Override
		public FxExpiryDateOrScheduleModel build() {
			return new FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelImpl(this);
		}
		
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder prune() {
			if (expiryDate!=null && !expiryDate.prune().hasData()) expiryDate = null;
			if (expirySchedule!=null && !expirySchedule.prune().hasData()) expirySchedule = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExpiryDate()!=null && getExpiryDate().hasData()) return true;
			if (getExpirySchedule()!=null && getExpirySchedule().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder o = (FxExpiryDateOrScheduleModel.FxExpiryDateOrScheduleModelBuilder) other;
			
			merger.mergeRosetta(getExpiryDate(), o.getExpiryDate(), this::setExpiryDate);
			merger.mergeRosetta(getExpirySchedule(), o.getExpirySchedule(), this::setExpirySchedule);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxExpiryDateOrScheduleModel _that = getType().cast(o);
		
			if (!Objects.equals(expiryDate, _that.getExpiryDate())) return false;
			if (!Objects.equals(expirySchedule, _that.getExpirySchedule())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (expiryDate != null ? expiryDate.hashCode() : 0);
			_result = 31 * _result + (expirySchedule != null ? expirySchedule.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxExpiryDateOrScheduleModelBuilder {" +
				"expiryDate=" + this.expiryDate + ", " +
				"expirySchedule=" + this.expirySchedule +
			'}';
		}
	}
}

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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityExercisePeriods;
import fpml.confirmation.CommodityExercisePeriods.CommodityExercisePeriodsBuilder;
import fpml.confirmation.CommodityExercisePeriods.CommodityExercisePeriodsBuilderImpl;
import fpml.confirmation.CommodityExercisePeriods.CommodityExercisePeriodsImpl;
import fpml.confirmation.meta.CommodityExercisePeriodsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityExercisePeriods", builder=CommodityExercisePeriods.CommodityExercisePeriodsBuilderImpl.class, version="${project.version}")
public interface CommodityExercisePeriods extends RosettaModelObject {

	CommodityExercisePeriodsMeta metaData = new CommodityExercisePeriodsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day of the exercise period for an American style option.
	 */
	AdjustableOrRelativeDate getCommencementDate();
	/**
	 * The last day within an exercise period for an American style option. For a European style option it is the only day within the exercise period.
	 */
	AdjustableOrRelativeDate getExpirationDate();

	/*********************** Build Methods  ***********************/
	CommodityExercisePeriods build();
	
	CommodityExercisePeriods.CommodityExercisePeriodsBuilder toBuilder();
	
	static CommodityExercisePeriods.CommodityExercisePeriodsBuilder builder() {
		return new CommodityExercisePeriods.CommodityExercisePeriodsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityExercisePeriods> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityExercisePeriods> getType() {
		return CommodityExercisePeriods.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.class, getCommencementDate());
		processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.class, getExpirationDate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityExercisePeriodsBuilder extends CommodityExercisePeriods, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate();
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate);
		CommodityExercisePeriods.CommodityExercisePeriodsBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commencementDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getCommencementDate());
			processRosetta(path.newSubPath("expirationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getExpirationDate());
		}
		

		CommodityExercisePeriods.CommodityExercisePeriodsBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityExercisePeriods  ***********************/
	class CommodityExercisePeriodsImpl implements CommodityExercisePeriods {
		private final AdjustableOrRelativeDate commencementDate;
		private final AdjustableOrRelativeDate expirationDate;
		
		protected CommodityExercisePeriodsImpl(CommodityExercisePeriods.CommodityExercisePeriodsBuilder builder) {
			this.commencementDate = ofNullable(builder.getCommencementDate()).map(f->f.build()).orElse(null);
			this.expirationDate = ofNullable(builder.getExpirationDate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableOrRelativeDate getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public CommodityExercisePeriods build() {
			return this;
		}
		
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder toBuilder() {
			CommodityExercisePeriods.CommodityExercisePeriodsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityExercisePeriods.CommodityExercisePeriodsBuilder builder) {
			ofNullable(getCommencementDate()).ifPresent(builder::setCommencementDate);
			ofNullable(getExpirationDate()).ifPresent(builder::setExpirationDate);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercisePeriods _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExercisePeriods {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityExercisePeriods  ***********************/
	class CommodityExercisePeriodsBuilderImpl implements CommodityExercisePeriods.CommodityExercisePeriodsBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder commencementDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder expirationDate;
	
		public CommodityExercisePeriodsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commencementDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getCommencementDate() {
			return commencementDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateCommencementDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (commencementDate!=null) {
				result = commencementDate;
			}
			else {
				result = commencementDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getExpirationDate() {
			return expirationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateExpirationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (expirationDate!=null) {
				result = expirationDate;
			}
			else {
				result = expirationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commencementDate")
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder setCommencementDate(AdjustableOrRelativeDate commencementDate) {
			this.commencementDate = commencementDate==null?null:commencementDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDate")
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder setExpirationDate(AdjustableOrRelativeDate expirationDate) {
			this.expirationDate = expirationDate==null?null:expirationDate.toBuilder();
			return this;
		}
		
		@Override
		public CommodityExercisePeriods build() {
			return new CommodityExercisePeriods.CommodityExercisePeriodsImpl(this);
		}
		
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder prune() {
			if (commencementDate!=null && !commencementDate.prune().hasData()) commencementDate = null;
			if (expirationDate!=null && !expirationDate.prune().hasData()) expirationDate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommencementDate()!=null && getCommencementDate().hasData()) return true;
			if (getExpirationDate()!=null && getExpirationDate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityExercisePeriods.CommodityExercisePeriodsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityExercisePeriods.CommodityExercisePeriodsBuilder o = (CommodityExercisePeriods.CommodityExercisePeriodsBuilder) other;
			
			merger.mergeRosetta(getCommencementDate(), o.getCommencementDate(), this::setCommencementDate);
			merger.mergeRosetta(getExpirationDate(), o.getExpirationDate(), this::setExpirationDate);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityExercisePeriods _that = getType().cast(o);
		
			if (!Objects.equals(commencementDate, _that.getCommencementDate())) return false;
			if (!Objects.equals(expirationDate, _that.getExpirationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commencementDate != null ? commencementDate.hashCode() : 0);
			_result = 31 * _result + (expirationDate != null ? expirationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityExercisePeriodsBuilder {" +
				"commencementDate=" + this.commencementDate + ", " +
				"expirationDate=" + this.expirationDate +
			'}';
		}
	}
}

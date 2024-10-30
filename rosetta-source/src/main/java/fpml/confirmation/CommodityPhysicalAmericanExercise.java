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
import fpml.confirmation.CommodityPhysicalAmericanExercise;
import fpml.confirmation.CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder;
import fpml.confirmation.CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl;
import fpml.confirmation.CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseImpl;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.Exercise;
import fpml.confirmation.Exercise.ExerciseBuilder;
import fpml.confirmation.Exercise.ExerciseBuilderImpl;
import fpml.confirmation.Exercise.ExerciseImpl;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.meta.CommodityPhysicalAmericanExerciseMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The parameters for defining the expiration date(s) and time(s) for an American style option.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPhysicalAmericanExercise", builder=CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPhysicalAmericanExercise extends Exercise {

	CommodityPhysicalAmericanExerciseMeta metaData = new CommodityPhysicalAmericanExerciseMeta();

	/*********************** Getter Methods  ***********************/
	CommodityPhysicalAmericanExerciseSequence0 getCommodityPhysicalAmericanExerciseSequence0();
	CommodityPhysicalAmericanExerciseSequence1 getCommodityPhysicalAmericanExerciseSequence1();
	/**
	 * For a Bermuda or American style option, the latest time on an exercise business day (excluding the expiration date) within the exercise period that notice can be given by the buyer to the seller or seller&#39;s agent. Notice of exercise given after this time will be deemed to have been given on the next exercise business day.
	 */
	PrevailingTime getLatestExerciseTime();
	/**
	 * The specific time of day at which the option expires.
	 */
	PrevailingTime getExpirationTime();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalAmericanExercise build();
	
	CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder();
	
	static CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder() {
		return new CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalAmericanExercise> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalAmericanExercise> getType() {
		return CommodityPhysicalAmericanExercise.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityPhysicalAmericanExerciseSequence0"), processor, CommodityPhysicalAmericanExerciseSequence0.class, getCommodityPhysicalAmericanExerciseSequence0());
		processRosetta(path.newSubPath("commodityPhysicalAmericanExerciseSequence1"), processor, CommodityPhysicalAmericanExerciseSequence1.class, getCommodityPhysicalAmericanExerciseSequence1());
		processRosetta(path.newSubPath("latestExerciseTime"), processor, PrevailingTime.class, getLatestExerciseTime());
		processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.class, getExpirationTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalAmericanExerciseBuilder extends CommodityPhysicalAmericanExercise, Exercise.ExerciseBuilder {
		CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder getOrCreateCommodityPhysicalAmericanExerciseSequence0();
		CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder getCommodityPhysicalAmericanExerciseSequence0();
		CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder getOrCreateCommodityPhysicalAmericanExerciseSequence1();
		CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder getCommodityPhysicalAmericanExerciseSequence1();
		PrevailingTime.PrevailingTimeBuilder getOrCreateLatestExerciseTime();
		PrevailingTime.PrevailingTimeBuilder getLatestExerciseTime();
		PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime();
		PrevailingTime.PrevailingTimeBuilder getExpirationTime();
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setId(String id);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommodityPhysicalAmericanExerciseSequence0(CommodityPhysicalAmericanExerciseSequence0 commodityPhysicalAmericanExerciseSequence0);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommodityPhysicalAmericanExerciseSequence1(CommodityPhysicalAmericanExerciseSequence1 commodityPhysicalAmericanExerciseSequence1);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setLatestExerciseTime(PrevailingTime latestExerciseTime);
		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationTime(PrevailingTime expirationTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityPhysicalAmericanExerciseSequence0"), processor, CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder.class, getCommodityPhysicalAmericanExerciseSequence0());
			processRosetta(path.newSubPath("commodityPhysicalAmericanExerciseSequence1"), processor, CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder.class, getCommodityPhysicalAmericanExerciseSequence1());
			processRosetta(path.newSubPath("latestExerciseTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getLatestExerciseTime());
			processRosetta(path.newSubPath("expirationTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getExpirationTime());
		}
		

		CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalAmericanExercise  ***********************/
	class CommodityPhysicalAmericanExerciseImpl extends Exercise.ExerciseImpl implements CommodityPhysicalAmericanExercise {
		private final CommodityPhysicalAmericanExerciseSequence0 commodityPhysicalAmericanExerciseSequence0;
		private final CommodityPhysicalAmericanExerciseSequence1 commodityPhysicalAmericanExerciseSequence1;
		private final PrevailingTime latestExerciseTime;
		private final PrevailingTime expirationTime;
		
		protected CommodityPhysicalAmericanExerciseImpl(CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder) {
			super(builder);
			this.commodityPhysicalAmericanExerciseSequence0 = ofNullable(builder.getCommodityPhysicalAmericanExerciseSequence0()).map(f->f.build()).orElse(null);
			this.commodityPhysicalAmericanExerciseSequence1 = ofNullable(builder.getCommodityPhysicalAmericanExerciseSequence1()).map(f->f.build()).orElse(null);
			this.latestExerciseTime = ofNullable(builder.getLatestExerciseTime()).map(f->f.build()).orElse(null);
			this.expirationTime = ofNullable(builder.getExpirationTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence0")
		public CommodityPhysicalAmericanExerciseSequence0 getCommodityPhysicalAmericanExerciseSequence0() {
			return commodityPhysicalAmericanExerciseSequence0;
		}
		
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence1")
		public CommodityPhysicalAmericanExerciseSequence1 getCommodityPhysicalAmericanExerciseSequence1() {
			return commodityPhysicalAmericanExerciseSequence1;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		public PrevailingTime getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public PrevailingTime getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder() {
			CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityPhysicalAmericanExerciseSequence0()).ifPresent(builder::setCommodityPhysicalAmericanExerciseSequence0);
			ofNullable(getCommodityPhysicalAmericanExerciseSequence1()).ifPresent(builder::setCommodityPhysicalAmericanExerciseSequence1);
			ofNullable(getLatestExerciseTime()).ifPresent(builder::setLatestExerciseTime);
			ofNullable(getExpirationTime()).ifPresent(builder::setExpirationTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commodityPhysicalAmericanExerciseSequence0, _that.getCommodityPhysicalAmericanExerciseSequence0())) return false;
			if (!Objects.equals(commodityPhysicalAmericanExerciseSequence1, _that.getCommodityPhysicalAmericanExerciseSequence1())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityPhysicalAmericanExerciseSequence0 != null ? commodityPhysicalAmericanExerciseSequence0.hashCode() : 0);
			_result = 31 * _result + (commodityPhysicalAmericanExerciseSequence1 != null ? commodityPhysicalAmericanExerciseSequence1.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExercise {" +
				"commodityPhysicalAmericanExerciseSequence0=" + this.commodityPhysicalAmericanExerciseSequence0 + ", " +
				"commodityPhysicalAmericanExerciseSequence1=" + this.commodityPhysicalAmericanExerciseSequence1 + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalAmericanExercise  ***********************/
	class CommodityPhysicalAmericanExerciseBuilderImpl extends Exercise.ExerciseBuilderImpl  implements CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder {
	
		protected CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder commodityPhysicalAmericanExerciseSequence0;
		protected CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder commodityPhysicalAmericanExerciseSequence1;
		protected PrevailingTime.PrevailingTimeBuilder latestExerciseTime;
		protected PrevailingTime.PrevailingTimeBuilder expirationTime;
	
		public CommodityPhysicalAmericanExerciseBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence0")
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder getCommodityPhysicalAmericanExerciseSequence0() {
			return commodityPhysicalAmericanExerciseSequence0;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder getOrCreateCommodityPhysicalAmericanExerciseSequence0() {
			CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder result;
			if (commodityPhysicalAmericanExerciseSequence0!=null) {
				result = commodityPhysicalAmericanExerciseSequence0;
			}
			else {
				result = commodityPhysicalAmericanExerciseSequence0 = CommodityPhysicalAmericanExerciseSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence1")
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder getCommodityPhysicalAmericanExerciseSequence1() {
			return commodityPhysicalAmericanExerciseSequence1;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder getOrCreateCommodityPhysicalAmericanExerciseSequence1() {
			CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder result;
			if (commodityPhysicalAmericanExerciseSequence1!=null) {
				result = commodityPhysicalAmericanExerciseSequence1;
			}
			else {
				result = commodityPhysicalAmericanExerciseSequence1 = CommodityPhysicalAmericanExerciseSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("latestExerciseTime")
		public PrevailingTime.PrevailingTimeBuilder getLatestExerciseTime() {
			return latestExerciseTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateLatestExerciseTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (latestExerciseTime!=null) {
				result = latestExerciseTime;
			}
			else {
				result = latestExerciseTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationTime")
		public PrevailingTime.PrevailingTimeBuilder getExpirationTime() {
			return expirationTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateExpirationTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (expirationTime!=null) {
				result = expirationTime;
			}
			else {
				result = expirationTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence0")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommodityPhysicalAmericanExerciseSequence0(CommodityPhysicalAmericanExerciseSequence0 commodityPhysicalAmericanExerciseSequence0) {
			this.commodityPhysicalAmericanExerciseSequence0 = commodityPhysicalAmericanExerciseSequence0==null?null:commodityPhysicalAmericanExerciseSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityPhysicalAmericanExerciseSequence1")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setCommodityPhysicalAmericanExerciseSequence1(CommodityPhysicalAmericanExerciseSequence1 commodityPhysicalAmericanExerciseSequence1) {
			this.commodityPhysicalAmericanExerciseSequence1 = commodityPhysicalAmericanExerciseSequence1==null?null:commodityPhysicalAmericanExerciseSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("latestExerciseTime")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setLatestExerciseTime(PrevailingTime latestExerciseTime) {
			this.latestExerciseTime = latestExerciseTime==null?null:latestExerciseTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationTime")
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder setExpirationTime(PrevailingTime expirationTime) {
			this.expirationTime = expirationTime==null?null:expirationTime.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExercise build() {
			return new CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseImpl(this);
		}
		
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder prune() {
			super.prune();
			if (commodityPhysicalAmericanExerciseSequence0!=null && !commodityPhysicalAmericanExerciseSequence0.prune().hasData()) commodityPhysicalAmericanExerciseSequence0 = null;
			if (commodityPhysicalAmericanExerciseSequence1!=null && !commodityPhysicalAmericanExerciseSequence1.prune().hasData()) commodityPhysicalAmericanExerciseSequence1 = null;
			if (latestExerciseTime!=null && !latestExerciseTime.prune().hasData()) latestExerciseTime = null;
			if (expirationTime!=null && !expirationTime.prune().hasData()) expirationTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityPhysicalAmericanExerciseSequence0()!=null && getCommodityPhysicalAmericanExerciseSequence0().hasData()) return true;
			if (getCommodityPhysicalAmericanExerciseSequence1()!=null && getCommodityPhysicalAmericanExerciseSequence1().hasData()) return true;
			if (getLatestExerciseTime()!=null && getLatestExerciseTime().hasData()) return true;
			if (getExpirationTime()!=null && getExpirationTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder o = (CommodityPhysicalAmericanExercise.CommodityPhysicalAmericanExerciseBuilder) other;
			
			merger.mergeRosetta(getCommodityPhysicalAmericanExerciseSequence0(), o.getCommodityPhysicalAmericanExerciseSequence0(), this::setCommodityPhysicalAmericanExerciseSequence0);
			merger.mergeRosetta(getCommodityPhysicalAmericanExerciseSequence1(), o.getCommodityPhysicalAmericanExerciseSequence1(), this::setCommodityPhysicalAmericanExerciseSequence1);
			merger.mergeRosetta(getLatestExerciseTime(), o.getLatestExerciseTime(), this::setLatestExerciseTime);
			merger.mergeRosetta(getExpirationTime(), o.getExpirationTime(), this::setExpirationTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalAmericanExercise _that = getType().cast(o);
		
			if (!Objects.equals(commodityPhysicalAmericanExerciseSequence0, _that.getCommodityPhysicalAmericanExerciseSequence0())) return false;
			if (!Objects.equals(commodityPhysicalAmericanExerciseSequence1, _that.getCommodityPhysicalAmericanExerciseSequence1())) return false;
			if (!Objects.equals(latestExerciseTime, _that.getLatestExerciseTime())) return false;
			if (!Objects.equals(expirationTime, _that.getExpirationTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityPhysicalAmericanExerciseSequence0 != null ? commodityPhysicalAmericanExerciseSequence0.hashCode() : 0);
			_result = 31 * _result + (commodityPhysicalAmericanExerciseSequence1 != null ? commodityPhysicalAmericanExerciseSequence1.hashCode() : 0);
			_result = 31 * _result + (latestExerciseTime != null ? latestExerciseTime.hashCode() : 0);
			_result = 31 * _result + (expirationTime != null ? expirationTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseBuilder {" +
				"commodityPhysicalAmericanExerciseSequence0=" + this.commodityPhysicalAmericanExerciseSequence0 + ", " +
				"commodityPhysicalAmericanExerciseSequence1=" + this.commodityPhysicalAmericanExerciseSequence1 + ", " +
				"latestExerciseTime=" + this.latestExerciseTime + ", " +
				"expirationTime=" + this.expirationTime +
			'}' + " " + super.toString();
		}
	}
}

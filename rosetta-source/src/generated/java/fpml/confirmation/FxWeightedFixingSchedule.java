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
import fpml.confirmation.FxWeightedFixingSchedule;
import fpml.confirmation.FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder;
import fpml.confirmation.FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilderImpl;
import fpml.confirmation.FxWeightedFixingSchedule.FxWeightedFixingScheduleImpl;
import fpml.confirmation.FxWeightedFixingScheduleSequence0;
import fpml.confirmation.FxWeightedFixingScheduleSequence1;
import fpml.confirmation.meta.FxWeightedFixingScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes a schedule of fixing dates as a parametric description, an explicit list of dates or both.
 * @version ${project.version}
 */
@RosettaDataType(value="FxWeightedFixingSchedule", builder=FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilderImpl.class, version="${project.version}")
public interface FxWeightedFixingSchedule extends RosettaModelObject {

	FxWeightedFixingScheduleMeta metaData = new FxWeightedFixingScheduleMeta();

	/*********************** Getter Methods  ***********************/
	FxWeightedFixingScheduleSequence0 getFxWeightedFixingScheduleSequence0();
	FxWeightedFixingScheduleSequence1 getFxWeightedFixingScheduleSequence1();

	/*********************** Build Methods  ***********************/
	FxWeightedFixingSchedule build();
	
	FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder toBuilder();
	
	static FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder builder() {
		return new FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxWeightedFixingSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxWeightedFixingSchedule> getType() {
		return FxWeightedFixingSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxWeightedFixingScheduleSequence0"), processor, FxWeightedFixingScheduleSequence0.class, getFxWeightedFixingScheduleSequence0());
		processRosetta(path.newSubPath("fxWeightedFixingScheduleSequence1"), processor, FxWeightedFixingScheduleSequence1.class, getFxWeightedFixingScheduleSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxWeightedFixingScheduleBuilder extends FxWeightedFixingSchedule, RosettaModelObjectBuilder {
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder getOrCreateFxWeightedFixingScheduleSequence0();
		FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder getFxWeightedFixingScheduleSequence0();
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder getOrCreateFxWeightedFixingScheduleSequence1();
		FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder getFxWeightedFixingScheduleSequence1();
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder setFxWeightedFixingScheduleSequence0(FxWeightedFixingScheduleSequence0 fxWeightedFixingScheduleSequence0);
		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder setFxWeightedFixingScheduleSequence1(FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxWeightedFixingScheduleSequence0"), processor, FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder.class, getFxWeightedFixingScheduleSequence0());
			processRosetta(path.newSubPath("fxWeightedFixingScheduleSequence1"), processor, FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder.class, getFxWeightedFixingScheduleSequence1());
		}
		

		FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxWeightedFixingSchedule  ***********************/
	class FxWeightedFixingScheduleImpl implements FxWeightedFixingSchedule {
		private final FxWeightedFixingScheduleSequence0 fxWeightedFixingScheduleSequence0;
		private final FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1;
		
		protected FxWeightedFixingScheduleImpl(FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder builder) {
			this.fxWeightedFixingScheduleSequence0 = ofNullable(builder.getFxWeightedFixingScheduleSequence0()).map(f->f.build()).orElse(null);
			this.fxWeightedFixingScheduleSequence1 = ofNullable(builder.getFxWeightedFixingScheduleSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence0")
		public FxWeightedFixingScheduleSequence0 getFxWeightedFixingScheduleSequence0() {
			return fxWeightedFixingScheduleSequence0;
		}
		
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence1")
		public FxWeightedFixingScheduleSequence1 getFxWeightedFixingScheduleSequence1() {
			return fxWeightedFixingScheduleSequence1;
		}
		
		@Override
		public FxWeightedFixingSchedule build() {
			return this;
		}
		
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder toBuilder() {
			FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder builder) {
			ofNullable(getFxWeightedFixingScheduleSequence0()).ifPresent(builder::setFxWeightedFixingScheduleSequence0);
			ofNullable(getFxWeightedFixingScheduleSequence1()).ifPresent(builder::setFxWeightedFixingScheduleSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxWeightedFixingScheduleSequence0, _that.getFxWeightedFixingScheduleSequence0())) return false;
			if (!Objects.equals(fxWeightedFixingScheduleSequence1, _that.getFxWeightedFixingScheduleSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxWeightedFixingScheduleSequence0 != null ? fxWeightedFixingScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxWeightedFixingScheduleSequence1 != null ? fxWeightedFixingScheduleSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingSchedule {" +
				"fxWeightedFixingScheduleSequence0=" + this.fxWeightedFixingScheduleSequence0 + ", " +
				"fxWeightedFixingScheduleSequence1=" + this.fxWeightedFixingScheduleSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of FxWeightedFixingSchedule  ***********************/
	class FxWeightedFixingScheduleBuilderImpl implements FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder {
	
		protected FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder fxWeightedFixingScheduleSequence0;
		protected FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder fxWeightedFixingScheduleSequence1;
	
		public FxWeightedFixingScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence0")
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder getFxWeightedFixingScheduleSequence0() {
			return fxWeightedFixingScheduleSequence0;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder getOrCreateFxWeightedFixingScheduleSequence0() {
			FxWeightedFixingScheduleSequence0.FxWeightedFixingScheduleSequence0Builder result;
			if (fxWeightedFixingScheduleSequence0!=null) {
				result = fxWeightedFixingScheduleSequence0;
			}
			else {
				result = fxWeightedFixingScheduleSequence0 = FxWeightedFixingScheduleSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence1")
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder getFxWeightedFixingScheduleSequence1() {
			return fxWeightedFixingScheduleSequence1;
		}
		
		@Override
		public FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder getOrCreateFxWeightedFixingScheduleSequence1() {
			FxWeightedFixingScheduleSequence1.FxWeightedFixingScheduleSequence1Builder result;
			if (fxWeightedFixingScheduleSequence1!=null) {
				result = fxWeightedFixingScheduleSequence1;
			}
			else {
				result = fxWeightedFixingScheduleSequence1 = FxWeightedFixingScheduleSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence0")
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder setFxWeightedFixingScheduleSequence0(FxWeightedFixingScheduleSequence0 fxWeightedFixingScheduleSequence0) {
			this.fxWeightedFixingScheduleSequence0 = fxWeightedFixingScheduleSequence0==null?null:fxWeightedFixingScheduleSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxWeightedFixingScheduleSequence1")
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder setFxWeightedFixingScheduleSequence1(FxWeightedFixingScheduleSequence1 fxWeightedFixingScheduleSequence1) {
			this.fxWeightedFixingScheduleSequence1 = fxWeightedFixingScheduleSequence1==null?null:fxWeightedFixingScheduleSequence1.toBuilder();
			return this;
		}
		
		@Override
		public FxWeightedFixingSchedule build() {
			return new FxWeightedFixingSchedule.FxWeightedFixingScheduleImpl(this);
		}
		
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder prune() {
			if (fxWeightedFixingScheduleSequence0!=null && !fxWeightedFixingScheduleSequence0.prune().hasData()) fxWeightedFixingScheduleSequence0 = null;
			if (fxWeightedFixingScheduleSequence1!=null && !fxWeightedFixingScheduleSequence1.prune().hasData()) fxWeightedFixingScheduleSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxWeightedFixingScheduleSequence0()!=null && getFxWeightedFixingScheduleSequence0().hasData()) return true;
			if (getFxWeightedFixingScheduleSequence1()!=null && getFxWeightedFixingScheduleSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder o = (FxWeightedFixingSchedule.FxWeightedFixingScheduleBuilder) other;
			
			merger.mergeRosetta(getFxWeightedFixingScheduleSequence0(), o.getFxWeightedFixingScheduleSequence0(), this::setFxWeightedFixingScheduleSequence0);
			merger.mergeRosetta(getFxWeightedFixingScheduleSequence1(), o.getFxWeightedFixingScheduleSequence1(), this::setFxWeightedFixingScheduleSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxWeightedFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxWeightedFixingScheduleSequence0, _that.getFxWeightedFixingScheduleSequence0())) return false;
			if (!Objects.equals(fxWeightedFixingScheduleSequence1, _that.getFxWeightedFixingScheduleSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxWeightedFixingScheduleSequence0 != null ? fxWeightedFixingScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxWeightedFixingScheduleSequence1 != null ? fxWeightedFixingScheduleSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxWeightedFixingScheduleBuilder {" +
				"fxWeightedFixingScheduleSequence0=" + this.fxWeightedFixingScheduleSequence0 + ", " +
				"fxWeightedFixingScheduleSequence1=" + this.fxWeightedFixingScheduleSequence1 +
			'}';
		}
	}
}

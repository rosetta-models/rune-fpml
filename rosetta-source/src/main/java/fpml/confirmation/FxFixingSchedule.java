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
import fpml.confirmation.FxFixingSchedule;
import fpml.confirmation.FxFixingSchedule.FxFixingScheduleBuilder;
import fpml.confirmation.FxFixingSchedule.FxFixingScheduleBuilderImpl;
import fpml.confirmation.FxFixingSchedule.FxFixingScheduleImpl;
import fpml.confirmation.FxFixingScheduleSequence0;
import fpml.confirmation.FxFixingScheduleSequence1;
import fpml.confirmation.meta.FxFixingScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes a schedule of fixing dates as a parametric description, an explicit list of dates or both.
 * @version ${project.version}
 */
@RosettaDataType(value="FxFixingSchedule", builder=FxFixingSchedule.FxFixingScheduleBuilderImpl.class, version="${project.version}")
public interface FxFixingSchedule extends RosettaModelObject {

	FxFixingScheduleMeta metaData = new FxFixingScheduleMeta();

	/*********************** Getter Methods  ***********************/
	FxFixingScheduleSequence0 getFxFixingScheduleSequence0();
	FxFixingScheduleSequence1 getFxFixingScheduleSequence1();

	/*********************** Build Methods  ***********************/
	FxFixingSchedule build();
	
	FxFixingSchedule.FxFixingScheduleBuilder toBuilder();
	
	static FxFixingSchedule.FxFixingScheduleBuilder builder() {
		return new FxFixingSchedule.FxFixingScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingSchedule> getType() {
		return FxFixingSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxFixingScheduleSequence0"), processor, FxFixingScheduleSequence0.class, getFxFixingScheduleSequence0());
		processRosetta(path.newSubPath("fxFixingScheduleSequence1"), processor, FxFixingScheduleSequence1.class, getFxFixingScheduleSequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingScheduleBuilder extends FxFixingSchedule, RosettaModelObjectBuilder {
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder getOrCreateFxFixingScheduleSequence0();
		FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder getFxFixingScheduleSequence0();
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder getOrCreateFxFixingScheduleSequence1();
		FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder getFxFixingScheduleSequence1();
		FxFixingSchedule.FxFixingScheduleBuilder setFxFixingScheduleSequence0(FxFixingScheduleSequence0 fxFixingScheduleSequence0);
		FxFixingSchedule.FxFixingScheduleBuilder setFxFixingScheduleSequence1(FxFixingScheduleSequence1 fxFixingScheduleSequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxFixingScheduleSequence0"), processor, FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder.class, getFxFixingScheduleSequence0());
			processRosetta(path.newSubPath("fxFixingScheduleSequence1"), processor, FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder.class, getFxFixingScheduleSequence1());
		}
		

		FxFixingSchedule.FxFixingScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingSchedule  ***********************/
	class FxFixingScheduleImpl implements FxFixingSchedule {
		private final FxFixingScheduleSequence0 fxFixingScheduleSequence0;
		private final FxFixingScheduleSequence1 fxFixingScheduleSequence1;
		
		protected FxFixingScheduleImpl(FxFixingSchedule.FxFixingScheduleBuilder builder) {
			this.fxFixingScheduleSequence0 = ofNullable(builder.getFxFixingScheduleSequence0()).map(f->f.build()).orElse(null);
			this.fxFixingScheduleSequence1 = ofNullable(builder.getFxFixingScheduleSequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSequence0")
		public FxFixingScheduleSequence0 getFxFixingScheduleSequence0() {
			return fxFixingScheduleSequence0;
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSequence1")
		public FxFixingScheduleSequence1 getFxFixingScheduleSequence1() {
			return fxFixingScheduleSequence1;
		}
		
		@Override
		public FxFixingSchedule build() {
			return this;
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder toBuilder() {
			FxFixingSchedule.FxFixingScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingSchedule.FxFixingScheduleBuilder builder) {
			ofNullable(getFxFixingScheduleSequence0()).ifPresent(builder::setFxFixingScheduleSequence0);
			ofNullable(getFxFixingScheduleSequence1()).ifPresent(builder::setFxFixingScheduleSequence1);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingScheduleSequence0, _that.getFxFixingScheduleSequence0())) return false;
			if (!Objects.equals(fxFixingScheduleSequence1, _that.getFxFixingScheduleSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingScheduleSequence0 != null ? fxFixingScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxFixingScheduleSequence1 != null ? fxFixingScheduleSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingSchedule {" +
				"fxFixingScheduleSequence0=" + this.fxFixingScheduleSequence0 + ", " +
				"fxFixingScheduleSequence1=" + this.fxFixingScheduleSequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingSchedule  ***********************/
	class FxFixingScheduleBuilderImpl implements FxFixingSchedule.FxFixingScheduleBuilder {
	
		protected FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder fxFixingScheduleSequence0;
		protected FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder fxFixingScheduleSequence1;
	
		public FxFixingScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxFixingScheduleSequence0")
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder getFxFixingScheduleSequence0() {
			return fxFixingScheduleSequence0;
		}
		
		@Override
		public FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder getOrCreateFxFixingScheduleSequence0() {
			FxFixingScheduleSequence0.FxFixingScheduleSequence0Builder result;
			if (fxFixingScheduleSequence0!=null) {
				result = fxFixingScheduleSequence0;
			}
			else {
				result = fxFixingScheduleSequence0 = FxFixingScheduleSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSequence1")
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder getFxFixingScheduleSequence1() {
			return fxFixingScheduleSequence1;
		}
		
		@Override
		public FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder getOrCreateFxFixingScheduleSequence1() {
			FxFixingScheduleSequence1.FxFixingScheduleSequence1Builder result;
			if (fxFixingScheduleSequence1!=null) {
				result = fxFixingScheduleSequence1;
			}
			else {
				result = fxFixingScheduleSequence1 = FxFixingScheduleSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxFixingScheduleSequence0")
		public FxFixingSchedule.FxFixingScheduleBuilder setFxFixingScheduleSequence0(FxFixingScheduleSequence0 fxFixingScheduleSequence0) {
			this.fxFixingScheduleSequence0 = fxFixingScheduleSequence0==null?null:fxFixingScheduleSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxFixingScheduleSequence1")
		public FxFixingSchedule.FxFixingScheduleBuilder setFxFixingScheduleSequence1(FxFixingScheduleSequence1 fxFixingScheduleSequence1) {
			this.fxFixingScheduleSequence1 = fxFixingScheduleSequence1==null?null:fxFixingScheduleSequence1.toBuilder();
			return this;
		}
		
		@Override
		public FxFixingSchedule build() {
			return new FxFixingSchedule.FxFixingScheduleImpl(this);
		}
		
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder prune() {
			if (fxFixingScheduleSequence0!=null && !fxFixingScheduleSequence0.prune().hasData()) fxFixingScheduleSequence0 = null;
			if (fxFixingScheduleSequence1!=null && !fxFixingScheduleSequence1.prune().hasData()) fxFixingScheduleSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxFixingScheduleSequence0()!=null && getFxFixingScheduleSequence0().hasData()) return true;
			if (getFxFixingScheduleSequence1()!=null && getFxFixingScheduleSequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingSchedule.FxFixingScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingSchedule.FxFixingScheduleBuilder o = (FxFixingSchedule.FxFixingScheduleBuilder) other;
			
			merger.mergeRosetta(getFxFixingScheduleSequence0(), o.getFxFixingScheduleSequence0(), this::setFxFixingScheduleSequence0);
			merger.mergeRosetta(getFxFixingScheduleSequence1(), o.getFxFixingScheduleSequence1(), this::setFxFixingScheduleSequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxFixingScheduleSequence0, _that.getFxFixingScheduleSequence0())) return false;
			if (!Objects.equals(fxFixingScheduleSequence1, _that.getFxFixingScheduleSequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxFixingScheduleSequence0 != null ? fxFixingScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxFixingScheduleSequence1 != null ? fxFixingScheduleSequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingScheduleBuilder {" +
				"fxFixingScheduleSequence0=" + this.fxFixingScheduleSequence0 + ", " +
				"fxFixingScheduleSequence1=" + this.fxFixingScheduleSequence1 +
			'}';
		}
	}
}

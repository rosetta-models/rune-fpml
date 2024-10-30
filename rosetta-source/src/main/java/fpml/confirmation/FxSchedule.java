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
import fpml.confirmation.FxSchedule;
import fpml.confirmation.FxSchedule.FxScheduleBuilder;
import fpml.confirmation.FxSchedule.FxScheduleBuilderImpl;
import fpml.confirmation.FxSchedule.FxScheduleImpl;
import fpml.confirmation.FxScheduleSequence0;
import fpml.confirmation.FxScheduleSequence1;
import fpml.confirmation.meta.FxScheduleMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The FxSchedule may be expressed as explicit adjusted dates, or a parametric representation plus optional adjusted dates, or as an offset plus optional adusted dates.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxSchedule", builder=FxSchedule.FxScheduleBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxSchedule extends RosettaModelObject {

	FxScheduleMeta metaData = new FxScheduleMeta();

	/*********************** Getter Methods  ***********************/
	FxScheduleSequence0 getFxScheduleSequence0();
	FxScheduleSequence1 getFxScheduleSequence1();
	String getId();

	/*********************** Build Methods  ***********************/
	FxSchedule build();
	
	FxSchedule.FxScheduleBuilder toBuilder();
	
	static FxSchedule.FxScheduleBuilder builder() {
		return new FxSchedule.FxScheduleBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxSchedule> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxSchedule> getType() {
		return FxSchedule.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.class, getFxScheduleSequence0());
		processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.class, getFxScheduleSequence1());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxScheduleBuilder extends FxSchedule, RosettaModelObjectBuilder {
		FxScheduleSequence0.FxScheduleSequence0Builder getOrCreateFxScheduleSequence0();
		FxScheduleSequence0.FxScheduleSequence0Builder getFxScheduleSequence0();
		FxScheduleSequence1.FxScheduleSequence1Builder getOrCreateFxScheduleSequence1();
		FxScheduleSequence1.FxScheduleSequence1Builder getFxScheduleSequence1();
		FxSchedule.FxScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0);
		FxSchedule.FxScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1);
		FxSchedule.FxScheduleBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxScheduleSequence0"), processor, FxScheduleSequence0.FxScheduleSequence0Builder.class, getFxScheduleSequence0());
			processRosetta(path.newSubPath("fxScheduleSequence1"), processor, FxScheduleSequence1.FxScheduleSequence1Builder.class, getFxScheduleSequence1());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		FxSchedule.FxScheduleBuilder prune();
	}

	/*********************** Immutable Implementation of FxSchedule  ***********************/
	class FxScheduleImpl implements FxSchedule {
		private final FxScheduleSequence0 fxScheduleSequence0;
		private final FxScheduleSequence1 fxScheduleSequence1;
		private final String id;
		
		protected FxScheduleImpl(FxSchedule.FxScheduleBuilder builder) {
			this.fxScheduleSequence0 = ofNullable(builder.getFxScheduleSequence0()).map(f->f.build()).orElse(null);
			this.fxScheduleSequence1 = ofNullable(builder.getFxScheduleSequence1()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("fxScheduleSequence0")
		public FxScheduleSequence0 getFxScheduleSequence0() {
			return fxScheduleSequence0;
		}
		
		@Override
		@RosettaAttribute("fxScheduleSequence1")
		public FxScheduleSequence1 getFxScheduleSequence1() {
			return fxScheduleSequence1;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public FxSchedule build() {
			return this;
		}
		
		@Override
		public FxSchedule.FxScheduleBuilder toBuilder() {
			FxSchedule.FxScheduleBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxSchedule.FxScheduleBuilder builder) {
			ofNullable(getFxScheduleSequence0()).ifPresent(builder::setFxScheduleSequence0);
			ofNullable(getFxScheduleSequence1()).ifPresent(builder::setFxScheduleSequence1);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxScheduleSequence0, _that.getFxScheduleSequence0())) return false;
			if (!Objects.equals(fxScheduleSequence1, _that.getFxScheduleSequence1())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxScheduleSequence0 != null ? fxScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxScheduleSequence1 != null ? fxScheduleSequence1.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxSchedule {" +
				"fxScheduleSequence0=" + this.fxScheduleSequence0 + ", " +
				"fxScheduleSequence1=" + this.fxScheduleSequence1 + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of FxSchedule  ***********************/
	class FxScheduleBuilderImpl implements FxSchedule.FxScheduleBuilder {
	
		protected FxScheduleSequence0.FxScheduleSequence0Builder fxScheduleSequence0;
		protected FxScheduleSequence1.FxScheduleSequence1Builder fxScheduleSequence1;
		protected String id;
	
		public FxScheduleBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxScheduleSequence0")
		public FxScheduleSequence0.FxScheduleSequence0Builder getFxScheduleSequence0() {
			return fxScheduleSequence0;
		}
		
		@Override
		public FxScheduleSequence0.FxScheduleSequence0Builder getOrCreateFxScheduleSequence0() {
			FxScheduleSequence0.FxScheduleSequence0Builder result;
			if (fxScheduleSequence0!=null) {
				result = fxScheduleSequence0;
			}
			else {
				result = fxScheduleSequence0 = FxScheduleSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxScheduleSequence1")
		public FxScheduleSequence1.FxScheduleSequence1Builder getFxScheduleSequence1() {
			return fxScheduleSequence1;
		}
		
		@Override
		public FxScheduleSequence1.FxScheduleSequence1Builder getOrCreateFxScheduleSequence1() {
			FxScheduleSequence1.FxScheduleSequence1Builder result;
			if (fxScheduleSequence1!=null) {
				result = fxScheduleSequence1;
			}
			else {
				result = fxScheduleSequence1 = FxScheduleSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("fxScheduleSequence0")
		public FxSchedule.FxScheduleBuilder setFxScheduleSequence0(FxScheduleSequence0 fxScheduleSequence0) {
			this.fxScheduleSequence0 = fxScheduleSequence0==null?null:fxScheduleSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxScheduleSequence1")
		public FxSchedule.FxScheduleBuilder setFxScheduleSequence1(FxScheduleSequence1 fxScheduleSequence1) {
			this.fxScheduleSequence1 = fxScheduleSequence1==null?null:fxScheduleSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public FxSchedule.FxScheduleBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public FxSchedule build() {
			return new FxSchedule.FxScheduleImpl(this);
		}
		
		@Override
		public FxSchedule.FxScheduleBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSchedule.FxScheduleBuilder prune() {
			if (fxScheduleSequence0!=null && !fxScheduleSequence0.prune().hasData()) fxScheduleSequence0 = null;
			if (fxScheduleSequence1!=null && !fxScheduleSequence1.prune().hasData()) fxScheduleSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxScheduleSequence0()!=null && getFxScheduleSequence0().hasData()) return true;
			if (getFxScheduleSequence1()!=null && getFxScheduleSequence1().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxSchedule.FxScheduleBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxSchedule.FxScheduleBuilder o = (FxSchedule.FxScheduleBuilder) other;
			
			merger.mergeRosetta(getFxScheduleSequence0(), o.getFxScheduleSequence0(), this::setFxScheduleSequence0);
			merger.mergeRosetta(getFxScheduleSequence1(), o.getFxScheduleSequence1(), this::setFxScheduleSequence1);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxSchedule _that = getType().cast(o);
		
			if (!Objects.equals(fxScheduleSequence0, _that.getFxScheduleSequence0())) return false;
			if (!Objects.equals(fxScheduleSequence1, _that.getFxScheduleSequence1())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxScheduleSequence0 != null ? fxScheduleSequence0.hashCode() : 0);
			_result = 31 * _result + (fxScheduleSequence1 != null ? fxScheduleSequence1.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxScheduleBuilder {" +
				"fxScheduleSequence0=" + this.fxScheduleSequence0 + ", " +
				"fxScheduleSequence1=" + this.fxScheduleSequence1 + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

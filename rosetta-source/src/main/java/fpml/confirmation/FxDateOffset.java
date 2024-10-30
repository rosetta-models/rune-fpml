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
import fpml.confirmation.FxDateOffset;
import fpml.confirmation.FxDateOffset.FxDateOffsetBuilder;
import fpml.confirmation.FxDateOffset.FxDateOffsetBuilderImpl;
import fpml.confirmation.FxDateOffset.FxDateOffsetImpl;
import fpml.confirmation.FxOffsetConventionEnum;
import fpml.confirmation.FxScheduleReference;
import fpml.confirmation.Period;
import fpml.confirmation.meta.FxDateOffsetMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The representation of the schedule as an offset relative to another schedule. For example, the settlement schedule may be relative to the expiry schedule by an FxForward offset.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxDateOffset", builder=FxDateOffset.FxDateOffsetBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxDateOffset extends RosettaModelObject {

	FxDateOffsetMeta metaData = new FxDateOffsetMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The FX Offset Convention can be FxSpot or FxForward.
	 */
	FxOffsetConventionEnum getConvention();
	/**
	 * The settlement offset to the expiry schedule or the expiry offset to the settlement schedule. It is only specified when the settlement convention is FxForward.
	 */
	Period getOffset();
	/**
	 * Indicates whether the settlement schedule is relative to the expiry schedule or the expiry schedule is relative to the settlement schedule.
	 */
	FxScheduleReference getRelativeTo();

	/*********************** Build Methods  ***********************/
	FxDateOffset build();
	
	FxDateOffset.FxDateOffsetBuilder toBuilder();
	
	static FxDateOffset.FxDateOffsetBuilder builder() {
		return new FxDateOffset.FxDateOffsetBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxDateOffset> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxDateOffset> getType() {
		return FxDateOffset.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("convention"), FxOffsetConventionEnum.class, getConvention(), this);
		processRosetta(path.newSubPath("offset"), processor, Period.class, getOffset());
		processRosetta(path.newSubPath("relativeTo"), processor, FxScheduleReference.class, getRelativeTo());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxDateOffsetBuilder extends FxDateOffset, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateOffset();
		Period.PeriodBuilder getOffset();
		FxScheduleReference.FxScheduleReferenceBuilder getOrCreateRelativeTo();
		FxScheduleReference.FxScheduleReferenceBuilder getRelativeTo();
		FxDateOffset.FxDateOffsetBuilder setConvention(FxOffsetConventionEnum convention);
		FxDateOffset.FxDateOffsetBuilder setOffset(Period offset);
		FxDateOffset.FxDateOffsetBuilder setRelativeTo(FxScheduleReference relativeTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("convention"), FxOffsetConventionEnum.class, getConvention(), this);
			processRosetta(path.newSubPath("offset"), processor, Period.PeriodBuilder.class, getOffset());
			processRosetta(path.newSubPath("relativeTo"), processor, FxScheduleReference.FxScheduleReferenceBuilder.class, getRelativeTo());
		}
		

		FxDateOffset.FxDateOffsetBuilder prune();
	}

	/*********************** Immutable Implementation of FxDateOffset  ***********************/
	class FxDateOffsetImpl implements FxDateOffset {
		private final FxOffsetConventionEnum convention;
		private final Period offset;
		private final FxScheduleReference relativeTo;
		
		protected FxDateOffsetImpl(FxDateOffset.FxDateOffsetBuilder builder) {
			this.convention = builder.getConvention();
			this.offset = ofNullable(builder.getOffset()).map(f->f.build()).orElse(null);
			this.relativeTo = ofNullable(builder.getRelativeTo()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("convention")
		public FxOffsetConventionEnum getConvention() {
			return convention;
		}
		
		@Override
		@RosettaAttribute("offset")
		public Period getOffset() {
			return offset;
		}
		
		@Override
		@RosettaAttribute("relativeTo")
		public FxScheduleReference getRelativeTo() {
			return relativeTo;
		}
		
		@Override
		public FxDateOffset build() {
			return this;
		}
		
		@Override
		public FxDateOffset.FxDateOffsetBuilder toBuilder() {
			FxDateOffset.FxDateOffsetBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxDateOffset.FxDateOffsetBuilder builder) {
			ofNullable(getConvention()).ifPresent(builder::setConvention);
			ofNullable(getOffset()).ifPresent(builder::setOffset);
			ofNullable(getRelativeTo()).ifPresent(builder::setRelativeTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(convention, _that.getConvention())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			if (!Objects.equals(relativeTo, _that.getRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (convention != null ? convention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			_result = 31 * _result + (relativeTo != null ? relativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDateOffset {" +
				"convention=" + this.convention + ", " +
				"offset=" + this.offset + ", " +
				"relativeTo=" + this.relativeTo +
			'}';
		}
	}

	/*********************** Builder Implementation of FxDateOffset  ***********************/
	class FxDateOffsetBuilderImpl implements FxDateOffset.FxDateOffsetBuilder {
	
		protected FxOffsetConventionEnum convention;
		protected Period.PeriodBuilder offset;
		protected FxScheduleReference.FxScheduleReferenceBuilder relativeTo;
	
		public FxDateOffsetBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("convention")
		public FxOffsetConventionEnum getConvention() {
			return convention;
		}
		
		@Override
		@RosettaAttribute("offset")
		public Period.PeriodBuilder getOffset() {
			return offset;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateOffset() {
			Period.PeriodBuilder result;
			if (offset!=null) {
				result = offset;
			}
			else {
				result = offset = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeTo")
		public FxScheduleReference.FxScheduleReferenceBuilder getRelativeTo() {
			return relativeTo;
		}
		
		@Override
		public FxScheduleReference.FxScheduleReferenceBuilder getOrCreateRelativeTo() {
			FxScheduleReference.FxScheduleReferenceBuilder result;
			if (relativeTo!=null) {
				result = relativeTo;
			}
			else {
				result = relativeTo = FxScheduleReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("convention")
		public FxDateOffset.FxDateOffsetBuilder setConvention(FxOffsetConventionEnum convention) {
			this.convention = convention==null?null:convention;
			return this;
		}
		@Override
		@RosettaAttribute("offset")
		public FxDateOffset.FxDateOffsetBuilder setOffset(Period offset) {
			this.offset = offset==null?null:offset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeTo")
		public FxDateOffset.FxDateOffsetBuilder setRelativeTo(FxScheduleReference relativeTo) {
			this.relativeTo = relativeTo==null?null:relativeTo.toBuilder();
			return this;
		}
		
		@Override
		public FxDateOffset build() {
			return new FxDateOffset.FxDateOffsetImpl(this);
		}
		
		@Override
		public FxDateOffset.FxDateOffsetBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDateOffset.FxDateOffsetBuilder prune() {
			if (offset!=null && !offset.prune().hasData()) offset = null;
			if (relativeTo!=null && !relativeTo.prune().hasData()) relativeTo = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getConvention()!=null) return true;
			if (getOffset()!=null && getOffset().hasData()) return true;
			if (getRelativeTo()!=null && getRelativeTo().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxDateOffset.FxDateOffsetBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxDateOffset.FxDateOffsetBuilder o = (FxDateOffset.FxDateOffsetBuilder) other;
			
			merger.mergeRosetta(getOffset(), o.getOffset(), this::setOffset);
			merger.mergeRosetta(getRelativeTo(), o.getRelativeTo(), this::setRelativeTo);
			
			merger.mergeBasic(getConvention(), o.getConvention(), this::setConvention);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxDateOffset _that = getType().cast(o);
		
			if (!Objects.equals(convention, _that.getConvention())) return false;
			if (!Objects.equals(offset, _that.getOffset())) return false;
			if (!Objects.equals(relativeTo, _that.getRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (convention != null ? convention.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (offset != null ? offset.hashCode() : 0);
			_result = 31 * _result + (relativeTo != null ? relativeTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxDateOffsetBuilder {" +
				"convention=" + this.convention + ", " +
				"offset=" + this.offset + ", " +
				"relativeTo=" + this.relativeTo +
			'}';
		}
	}
}

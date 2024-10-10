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
import fpml.confirmation.AdjustableDates;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Impl;
import fpml.confirmation.PeriodicDates;
import fpml.confirmation.RelativeDates;
import fpml.confirmation.meta.AdjustableRelativeOrPeriodicDates2Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type giving the choice between defining a series of dates as an explicit list of dates together with applicable adjustments, or as relative to some other series of (anchor) dates, or as a set of factors to specify periodic occurences.
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableRelativeOrPeriodicDates2", builder=AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl.class, version="${project.version}")
public interface AdjustableRelativeOrPeriodicDates2 extends RosettaModelObject {

	AdjustableRelativeOrPeriodicDates2Meta metaData = new AdjustableRelativeOrPeriodicDates2Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDates getAdjustableDates();
	/**
	 * A series of dates specified as some offset to another series of dates (the anchor dates).
	 */
	RelativeDates getRelativeDates();
	PeriodicDates getPeriodicDates();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableRelativeOrPeriodicDates2 build();
	
	AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder();
	
	static AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder() {
		return new AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates2> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableRelativeOrPeriodicDates2> getType() {
		return AdjustableRelativeOrPeriodicDates2.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.class, getRelativeDates());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableRelativeOrPeriodicDates2Builder extends AdjustableRelativeOrPeriodicDates2, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates();
		RelativeDates.RelativeDatesBuilder getRelativeDates();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setRelativeDates(RelativeDates relativeDates);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setPeriodicDates(PeriodicDates periodicDates);
		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDates"), processor, RelativeDates.RelativeDatesBuilder.class, getRelativeDates());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder prune();
	}

	/*********************** Immutable Implementation of AdjustableRelativeOrPeriodicDates2  ***********************/
	class AdjustableRelativeOrPeriodicDates2Impl implements AdjustableRelativeOrPeriodicDates2 {
		private final AdjustableDates adjustableDates;
		private final RelativeDates relativeDates;
		private final PeriodicDates periodicDates;
		private final String id;
		
		protected AdjustableRelativeOrPeriodicDates2Impl(AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDates = ofNullable(builder.getRelativeDates()).map(f->f.build()).orElse(null);
			this.periodicDates = ofNullable(builder.getPeriodicDates()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDates")
		public RelativeDates getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		public PeriodicDates getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2 build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder() {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDates()).ifPresent(builder::setRelativeDates);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates2 _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates2 {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableRelativeOrPeriodicDates2  ***********************/
	class AdjustableRelativeOrPeriodicDates2BuilderImpl implements AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDates.RelativeDatesBuilder relativeDates;
		protected PeriodicDates.PeriodicDatesBuilder periodicDates;
		protected String id;
	
		public AdjustableRelativeOrPeriodicDates2BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates.AdjustableDatesBuilder getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		public AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates() {
			AdjustableDates.AdjustableDatesBuilder result;
			if (adjustableDates!=null) {
				result = adjustableDates;
			}
			else {
				result = adjustableDates = AdjustableDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeDates")
		public RelativeDates.RelativeDatesBuilder getRelativeDates() {
			return relativeDates;
		}
		
		@Override
		public RelativeDates.RelativeDatesBuilder getOrCreateRelativeDates() {
			RelativeDates.RelativeDatesBuilder result;
			if (relativeDates!=null) {
				result = relativeDates;
			}
			else {
				result = relativeDates = RelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("periodicDates")
		public PeriodicDates.PeriodicDatesBuilder getPeriodicDates() {
			return periodicDates;
		}
		
		@Override
		public PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates() {
			PeriodicDates.PeriodicDatesBuilder result;
			if (periodicDates!=null) {
				result = periodicDates;
			}
			else {
				result = periodicDates = PeriodicDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setAdjustableDates(AdjustableDates adjustableDates) {
			this.adjustableDates = adjustableDates==null?null:adjustableDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setRelativeDates(RelativeDates relativeDates) {
			this.relativeDates = relativeDates==null?null:relativeDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodicDates")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setPeriodicDates(PeriodicDates periodicDates) {
			this.periodicDates = periodicDates==null?null:periodicDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2 build() {
			return new AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Impl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDates!=null && !relativeDates.prune().hasData()) relativeDates = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDates()!=null && getRelativeDates().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder o = (AdjustableRelativeOrPeriodicDates2.AdjustableRelativeOrPeriodicDates2Builder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDates(), o.getRelativeDates(), this::setRelativeDates);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates2 _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDates, _that.getRelativeDates())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDates != null ? relativeDates.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates2Builder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDates=" + this.relativeDates + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

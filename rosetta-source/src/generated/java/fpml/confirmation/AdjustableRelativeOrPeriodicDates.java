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
import fpml.confirmation.AdjustableRelativeOrPeriodicDates;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl;
import fpml.confirmation.AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl;
import fpml.confirmation.PeriodicDates;
import fpml.confirmation.RelativeDateSequence;
import fpml.confirmation.meta.AdjustableRelativeOrPeriodicDatesMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="AdjustableRelativeOrPeriodicDates", builder=AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl.class, version="${project.version}")
public interface AdjustableRelativeOrPeriodicDates extends RosettaModelObject {

	AdjustableRelativeOrPeriodicDatesMeta metaData = new AdjustableRelativeOrPeriodicDatesMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A series of dates that shall be subject to adjustment if they would otherwise fall on a day that is not a business day in the specified business centers, together with the convention for adjusting the date.
	 */
	AdjustableDates getAdjustableDates();
	/**
	 * A series of dates specified as some offset to other dates (the anchor dates) which can
	 */
	RelativeDateSequence getRelativeDateSequence();
	PeriodicDates getPeriodicDates();
	String getId();

	/*********************** Build Methods  ***********************/
	AdjustableRelativeOrPeriodicDates build();
	
	AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder();
	
	static AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder() {
		return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdjustableRelativeOrPeriodicDates> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends AdjustableRelativeOrPeriodicDates> getType() {
		return AdjustableRelativeOrPeriodicDates.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.class, getAdjustableDates());
		processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.class, getRelativeDateSequence());
		processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.class, getPeriodicDates());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdjustableRelativeOrPeriodicDatesBuilder extends AdjustableRelativeOrPeriodicDates, RosettaModelObjectBuilder {
		AdjustableDates.AdjustableDatesBuilder getOrCreateAdjustableDates();
		AdjustableDates.AdjustableDatesBuilder getAdjustableDates();
		RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence();
		RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence();
		PeriodicDates.PeriodicDatesBuilder getOrCreatePeriodicDates();
		PeriodicDates.PeriodicDatesBuilder getPeriodicDates();
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates);
		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("adjustableDates"), processor, AdjustableDates.AdjustableDatesBuilder.class, getAdjustableDates());
			processRosetta(path.newSubPath("relativeDateSequence"), processor, RelativeDateSequence.RelativeDateSequenceBuilder.class, getRelativeDateSequence());
			processRosetta(path.newSubPath("periodicDates"), processor, PeriodicDates.PeriodicDatesBuilder.class, getPeriodicDates());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune();
	}

	/*********************** Immutable Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesImpl implements AdjustableRelativeOrPeriodicDates {
		private final AdjustableDates adjustableDates;
		private final RelativeDateSequence relativeDateSequence;
		private final PeriodicDates periodicDates;
		private final String id;
		
		protected AdjustableRelativeOrPeriodicDatesImpl(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			this.adjustableDates = ofNullable(builder.getAdjustableDates()).map(f->f.build()).orElse(null);
			this.relativeDateSequence = ofNullable(builder.getRelativeDateSequence()).map(f->f.build()).orElse(null);
			this.periodicDates = ofNullable(builder.getPeriodicDates()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("adjustableDates")
		public AdjustableDates getAdjustableDates() {
			return adjustableDates;
		}
		
		@Override
		@RosettaAttribute("relativeDateSequence")
		public RelativeDateSequence getRelativeDateSequence() {
			return relativeDateSequence;
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
		public AdjustableRelativeOrPeriodicDates build() {
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder builder) {
			ofNullable(getAdjustableDates()).ifPresent(builder::setAdjustableDates);
			ofNullable(getRelativeDateSequence()).ifPresent(builder::setRelativeDateSequence);
			ofNullable(getPeriodicDates()).ifPresent(builder::setPeriodicDates);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDates {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of AdjustableRelativeOrPeriodicDates  ***********************/
	class AdjustableRelativeOrPeriodicDatesBuilderImpl implements AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder {
	
		protected AdjustableDates.AdjustableDatesBuilder adjustableDates;
		protected RelativeDateSequence.RelativeDateSequenceBuilder relativeDateSequence;
		protected PeriodicDates.PeriodicDatesBuilder periodicDates;
		protected String id;
	
		public AdjustableRelativeOrPeriodicDatesBuilderImpl() {
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
		@RosettaAttribute("relativeDateSequence")
		public RelativeDateSequence.RelativeDateSequenceBuilder getRelativeDateSequence() {
			return relativeDateSequence;
		}
		
		@Override
		public RelativeDateSequence.RelativeDateSequenceBuilder getOrCreateRelativeDateSequence() {
			RelativeDateSequence.RelativeDateSequenceBuilder result;
			if (relativeDateSequence!=null) {
				result = relativeDateSequence;
			}
			else {
				result = relativeDateSequence = RelativeDateSequence.builder();
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
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setAdjustableDates(AdjustableDates adjustableDates) {
			this.adjustableDates = adjustableDates==null?null:adjustableDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeDateSequence")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setRelativeDateSequence(RelativeDateSequence relativeDateSequence) {
			this.relativeDateSequence = relativeDateSequence==null?null:relativeDateSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("periodicDates")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setPeriodicDates(PeriodicDates periodicDates) {
			this.periodicDates = periodicDates==null?null:periodicDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates build() {
			return new AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesImpl(this);
		}
		
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder prune() {
			if (adjustableDates!=null && !adjustableDates.prune().hasData()) adjustableDates = null;
			if (relativeDateSequence!=null && !relativeDateSequence.prune().hasData()) relativeDateSequence = null;
			if (periodicDates!=null && !periodicDates.prune().hasData()) periodicDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAdjustableDates()!=null && getAdjustableDates().hasData()) return true;
			if (getRelativeDateSequence()!=null && getRelativeDateSequence().hasData()) return true;
			if (getPeriodicDates()!=null && getPeriodicDates().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder o = (AdjustableRelativeOrPeriodicDates.AdjustableRelativeOrPeriodicDatesBuilder) other;
			
			merger.mergeRosetta(getAdjustableDates(), o.getAdjustableDates(), this::setAdjustableDates);
			merger.mergeRosetta(getRelativeDateSequence(), o.getRelativeDateSequence(), this::setRelativeDateSequence);
			merger.mergeRosetta(getPeriodicDates(), o.getPeriodicDates(), this::setPeriodicDates);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdjustableRelativeOrPeriodicDates _that = getType().cast(o);
		
			if (!Objects.equals(adjustableDates, _that.getAdjustableDates())) return false;
			if (!Objects.equals(relativeDateSequence, _that.getRelativeDateSequence())) return false;
			if (!Objects.equals(periodicDates, _that.getPeriodicDates())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (adjustableDates != null ? adjustableDates.hashCode() : 0);
			_result = 31 * _result + (relativeDateSequence != null ? relativeDateSequence.hashCode() : 0);
			_result = 31 * _result + (periodicDates != null ? periodicDates.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdjustableRelativeOrPeriodicDatesBuilder {" +
				"adjustableDates=" + this.adjustableDates + ", " +
				"relativeDateSequence=" + this.relativeDateSequence + ", " +
				"periodicDates=" + this.periodicDates + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

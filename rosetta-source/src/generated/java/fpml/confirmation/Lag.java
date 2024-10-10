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
import fpml.confirmation.Lag;
import fpml.confirmation.Lag.LagBuilder;
import fpml.confirmation.Lag.LagBuilderImpl;
import fpml.confirmation.Lag.LagImpl;
import fpml.confirmation.Period;
import fpml.confirmation.meta.LagMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * An observation period that is offset from a Calculation Period.
 * @version ${project.version}
 */
@RosettaDataType(value="Lag", builder=Lag.LagBuilderImpl.class, version="${project.version}")
public interface Lag extends RosettaModelObject {

	LagMeta metaData = new LagMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The period during which observations will be made. If a firstObservationDateOffset is specified, the observation period will start the specified interval prior to each Calculation Period - i.e. if the firstObservationDateOffset is 4 months and the lagDuration is 3 months, observations will be taken in months 4,3 and 2 (but not 1) prior to each Calculation Period. If no firstObservationDate is specified, the observation period will end immediately preceding each Calculation Period.
	 */
	Period getLagDuration();
	/**
	 * The interval between the start of each lagDuration and the start of each respective calculation period.
	 */
	Period getFirstObservationDateOffset();
	String getId();

	/*********************** Build Methods  ***********************/
	Lag build();
	
	Lag.LagBuilder toBuilder();
	
	static Lag.LagBuilder builder() {
		return new Lag.LagBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Lag> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Lag> getType() {
		return Lag.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lagDuration"), processor, Period.class, getLagDuration());
		processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Period.class, getFirstObservationDateOffset());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LagBuilder extends Lag, RosettaModelObjectBuilder {
		Period.PeriodBuilder getOrCreateLagDuration();
		Period.PeriodBuilder getLagDuration();
		Period.PeriodBuilder getOrCreateFirstObservationDateOffset();
		Period.PeriodBuilder getFirstObservationDateOffset();
		Lag.LagBuilder setLagDuration(Period lagDuration);
		Lag.LagBuilder setFirstObservationDateOffset(Period firstObservationDateOffset);
		Lag.LagBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lagDuration"), processor, Period.PeriodBuilder.class, getLagDuration());
			processRosetta(path.newSubPath("firstObservationDateOffset"), processor, Period.PeriodBuilder.class, getFirstObservationDateOffset());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		Lag.LagBuilder prune();
	}

	/*********************** Immutable Implementation of Lag  ***********************/
	class LagImpl implements Lag {
		private final Period lagDuration;
		private final Period firstObservationDateOffset;
		private final String id;
		
		protected LagImpl(Lag.LagBuilder builder) {
			this.lagDuration = ofNullable(builder.getLagDuration()).map(f->f.build()).orElse(null);
			this.firstObservationDateOffset = ofNullable(builder.getFirstObservationDateOffset()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("lagDuration")
		public Period getLagDuration() {
			return lagDuration;
		}
		
		@Override
		@RosettaAttribute("firstObservationDateOffset")
		public Period getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public Lag build() {
			return this;
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			Lag.LagBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Lag.LagBuilder builder) {
			ofNullable(getLagDuration()).ifPresent(builder::setLagDuration);
			ofNullable(getFirstObservationDateOffset()).ifPresent(builder::setFirstObservationDateOffset);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Lag {" +
				"lagDuration=" + this.lagDuration + ", " +
				"firstObservationDateOffset=" + this.firstObservationDateOffset + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of Lag  ***********************/
	class LagBuilderImpl implements Lag.LagBuilder {
	
		protected Period.PeriodBuilder lagDuration;
		protected Period.PeriodBuilder firstObservationDateOffset;
		protected String id;
	
		public LagBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lagDuration")
		public Period.PeriodBuilder getLagDuration() {
			return lagDuration;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateLagDuration() {
			Period.PeriodBuilder result;
			if (lagDuration!=null) {
				result = lagDuration;
			}
			else {
				result = lagDuration = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("firstObservationDateOffset")
		public Period.PeriodBuilder getFirstObservationDateOffset() {
			return firstObservationDateOffset;
		}
		
		@Override
		public Period.PeriodBuilder getOrCreateFirstObservationDateOffset() {
			Period.PeriodBuilder result;
			if (firstObservationDateOffset!=null) {
				result = firstObservationDateOffset;
			}
			else {
				result = firstObservationDateOffset = Period.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("lagDuration")
		public Lag.LagBuilder setLagDuration(Period lagDuration) {
			this.lagDuration = lagDuration==null?null:lagDuration.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("firstObservationDateOffset")
		public Lag.LagBuilder setFirstObservationDateOffset(Period firstObservationDateOffset) {
			this.firstObservationDateOffset = firstObservationDateOffset==null?null:firstObservationDateOffset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public Lag.LagBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public Lag build() {
			return new Lag.LagImpl(this);
		}
		
		@Override
		public Lag.LagBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder prune() {
			if (lagDuration!=null && !lagDuration.prune().hasData()) lagDuration = null;
			if (firstObservationDateOffset!=null && !firstObservationDateOffset.prune().hasData()) firstObservationDateOffset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLagDuration()!=null && getLagDuration().hasData()) return true;
			if (getFirstObservationDateOffset()!=null && getFirstObservationDateOffset().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Lag.LagBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Lag.LagBuilder o = (Lag.LagBuilder) other;
			
			merger.mergeRosetta(getLagDuration(), o.getLagDuration(), this::setLagDuration);
			merger.mergeRosetta(getFirstObservationDateOffset(), o.getFirstObservationDateOffset(), this::setFirstObservationDateOffset);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Lag _that = getType().cast(o);
		
			if (!Objects.equals(lagDuration, _that.getLagDuration())) return false;
			if (!Objects.equals(firstObservationDateOffset, _that.getFirstObservationDateOffset())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lagDuration != null ? lagDuration.hashCode() : 0);
			_result = 31 * _result + (firstObservationDateOffset != null ? firstObservationDateOffset.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LagBuilder {" +
				"lagDuration=" + this.lagDuration + ", " +
				"firstObservationDateOffset=" + this.firstObservationDateOffset + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

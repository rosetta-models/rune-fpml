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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.NoTouchRateObservation;
import fpml.confirmation.NoTouchRateObservation.NoTouchRateObservationBuilder;
import fpml.confirmation.NoTouchRateObservation.NoTouchRateObservationBuilderImpl;
import fpml.confirmation.NoTouchRateObservation.NoTouchRateObservationImpl;
import fpml.confirmation.NoTouchRateObservationSequence0;
import fpml.confirmation.NoTouchRateObservationSequence1;
import fpml.confirmation.NoTouchUpperBarrierObservation;
import fpml.confirmation.meta.NoTouchRateObservationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NoTouchRateObservation", builder=NoTouchRateObservation.NoTouchRateObservationBuilderImpl.class, version="${project.version}")
public interface NoTouchRateObservation extends RosettaModelObject {

	NoTouchRateObservationMeta metaData = new NoTouchRateObservationMeta();

	/*********************** Getter Methods  ***********************/
	Date getObservationStartDate();
	Date getObservationEndDate();
	NoTouchRateObservationSequence0 getNoTouchRateObservationSequence0();
	NoTouchUpperBarrierObservation getUpperBarrier();
	NoTouchRateObservationSequence1 getNoTouchRateObservationSequence1();
	/**
	 * If the touch or no touch event hasn&#39;t generated an exercise, then we specify whether the option is exercisable or not.
	 */
	Boolean getIsExercisable();

	/*********************** Build Methods  ***********************/
	NoTouchRateObservation build();
	
	NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder();
	
	static NoTouchRateObservation.NoTouchRateObservationBuilder builder() {
		return new NoTouchRateObservation.NoTouchRateObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NoTouchRateObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NoTouchRateObservation> getType() {
		return NoTouchRateObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
		processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
		processRosetta(path.newSubPath("noTouchRateObservationSequence0"), processor, NoTouchRateObservationSequence0.class, getNoTouchRateObservationSequence0());
		processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.class, getUpperBarrier());
		processRosetta(path.newSubPath("noTouchRateObservationSequence1"), processor, NoTouchRateObservationSequence1.class, getNoTouchRateObservationSequence1());
		processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NoTouchRateObservationBuilder extends NoTouchRateObservation, RosettaModelObjectBuilder {
		NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder getOrCreateNoTouchRateObservationSequence0();
		NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder getNoTouchRateObservationSequence0();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier();
		NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier();
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder getOrCreateNoTouchRateObservationSequence1();
		NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder getNoTouchRateObservationSequence1();
		NoTouchRateObservation.NoTouchRateObservationBuilder setObservationStartDate(Date observationStartDate);
		NoTouchRateObservation.NoTouchRateObservationBuilder setObservationEndDate(Date observationEndDate);
		NoTouchRateObservation.NoTouchRateObservationBuilder setNoTouchRateObservationSequence0(NoTouchRateObservationSequence0 noTouchRateObservationSequence0);
		NoTouchRateObservation.NoTouchRateObservationBuilder setUpperBarrier(NoTouchUpperBarrierObservation upperBarrier);
		NoTouchRateObservation.NoTouchRateObservationBuilder setNoTouchRateObservationSequence1(NoTouchRateObservationSequence1 noTouchRateObservationSequence1);
		NoTouchRateObservation.NoTouchRateObservationBuilder setIsExercisable(Boolean isExercisable);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("observationStartDate"), Date.class, getObservationStartDate(), this);
			processor.processBasic(path.newSubPath("observationEndDate"), Date.class, getObservationEndDate(), this);
			processRosetta(path.newSubPath("noTouchRateObservationSequence0"), processor, NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder.class, getNoTouchRateObservationSequence0());
			processRosetta(path.newSubPath("upperBarrier"), processor, NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder.class, getUpperBarrier());
			processRosetta(path.newSubPath("noTouchRateObservationSequence1"), processor, NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder.class, getNoTouchRateObservationSequence1());
			processor.processBasic(path.newSubPath("isExercisable"), Boolean.class, getIsExercisable(), this);
		}
		

		NoTouchRateObservation.NoTouchRateObservationBuilder prune();
	}

	/*********************** Immutable Implementation of NoTouchRateObservation  ***********************/
	class NoTouchRateObservationImpl implements NoTouchRateObservation {
		private final Date observationStartDate;
		private final Date observationEndDate;
		private final NoTouchRateObservationSequence0 noTouchRateObservationSequence0;
		private final NoTouchUpperBarrierObservation upperBarrier;
		private final NoTouchRateObservationSequence1 noTouchRateObservationSequence1;
		private final Boolean isExercisable;
		
		protected NoTouchRateObservationImpl(NoTouchRateObservation.NoTouchRateObservationBuilder builder) {
			this.observationStartDate = builder.getObservationStartDate();
			this.observationEndDate = builder.getObservationEndDate();
			this.noTouchRateObservationSequence0 = ofNullable(builder.getNoTouchRateObservationSequence0()).map(f->f.build()).orElse(null);
			this.upperBarrier = ofNullable(builder.getUpperBarrier()).map(f->f.build()).orElse(null);
			this.noTouchRateObservationSequence1 = ofNullable(builder.getNoTouchRateObservationSequence1()).map(f->f.build()).orElse(null);
			this.isExercisable = builder.getIsExercisable();
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public Date getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		public Date getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("noTouchRateObservationSequence0")
		public NoTouchRateObservationSequence0 getNoTouchRateObservationSequence0() {
			return noTouchRateObservationSequence0;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		@RosettaAttribute("noTouchRateObservationSequence1")
		public NoTouchRateObservationSequence1 getNoTouchRateObservationSequence1() {
			return noTouchRateObservationSequence1;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@Override
		public NoTouchRateObservation build() {
			return this;
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder() {
			NoTouchRateObservation.NoTouchRateObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NoTouchRateObservation.NoTouchRateObservationBuilder builder) {
			ofNullable(getObservationStartDate()).ifPresent(builder::setObservationStartDate);
			ofNullable(getObservationEndDate()).ifPresent(builder::setObservationEndDate);
			ofNullable(getNoTouchRateObservationSequence0()).ifPresent(builder::setNoTouchRateObservationSequence0);
			ofNullable(getUpperBarrier()).ifPresent(builder::setUpperBarrier);
			ofNullable(getNoTouchRateObservationSequence1()).ifPresent(builder::setNoTouchRateObservationSequence1);
			ofNullable(getIsExercisable()).ifPresent(builder::setIsExercisable);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(noTouchRateObservationSequence0, _that.getNoTouchRateObservationSequence0())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			if (!Objects.equals(noTouchRateObservationSequence1, _that.getNoTouchRateObservationSequence1())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (noTouchRateObservationSequence0 != null ? noTouchRateObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			_result = 31 * _result + (noTouchRateObservationSequence1 != null ? noTouchRateObservationSequence1.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservation {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"noTouchRateObservationSequence0=" + this.noTouchRateObservationSequence0 + ", " +
				"upperBarrier=" + this.upperBarrier + ", " +
				"noTouchRateObservationSequence1=" + this.noTouchRateObservationSequence1 + ", " +
				"isExercisable=" + this.isExercisable +
			'}';
		}
	}

	/*********************** Builder Implementation of NoTouchRateObservation  ***********************/
	class NoTouchRateObservationBuilderImpl implements NoTouchRateObservation.NoTouchRateObservationBuilder {
	
		protected Date observationStartDate;
		protected Date observationEndDate;
		protected NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder noTouchRateObservationSequence0;
		protected NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder upperBarrier;
		protected NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder noTouchRateObservationSequence1;
		protected Boolean isExercisable;
	
		public NoTouchRateObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("observationStartDate")
		public Date getObservationStartDate() {
			return observationStartDate;
		}
		
		@Override
		@RosettaAttribute("observationEndDate")
		public Date getObservationEndDate() {
			return observationEndDate;
		}
		
		@Override
		@RosettaAttribute("noTouchRateObservationSequence0")
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder getNoTouchRateObservationSequence0() {
			return noTouchRateObservationSequence0;
		}
		
		@Override
		public NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder getOrCreateNoTouchRateObservationSequence0() {
			NoTouchRateObservationSequence0.NoTouchRateObservationSequence0Builder result;
			if (noTouchRateObservationSequence0!=null) {
				result = noTouchRateObservationSequence0;
			}
			else {
				result = noTouchRateObservationSequence0 = NoTouchRateObservationSequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getUpperBarrier() {
			return upperBarrier;
		}
		
		@Override
		public NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder getOrCreateUpperBarrier() {
			NoTouchUpperBarrierObservation.NoTouchUpperBarrierObservationBuilder result;
			if (upperBarrier!=null) {
				result = upperBarrier;
			}
			else {
				result = upperBarrier = NoTouchUpperBarrierObservation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("noTouchRateObservationSequence1")
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder getNoTouchRateObservationSequence1() {
			return noTouchRateObservationSequence1;
		}
		
		@Override
		public NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder getOrCreateNoTouchRateObservationSequence1() {
			NoTouchRateObservationSequence1.NoTouchRateObservationSequence1Builder result;
			if (noTouchRateObservationSequence1!=null) {
				result = noTouchRateObservationSequence1;
			}
			else {
				result = noTouchRateObservationSequence1 = NoTouchRateObservationSequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("isExercisable")
		public Boolean getIsExercisable() {
			return isExercisable;
		}
		
		@Override
		@RosettaAttribute("observationStartDate")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setObservationStartDate(Date observationStartDate) {
			this.observationStartDate = observationStartDate==null?null:observationStartDate;
			return this;
		}
		@Override
		@RosettaAttribute("observationEndDate")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setObservationEndDate(Date observationEndDate) {
			this.observationEndDate = observationEndDate==null?null:observationEndDate;
			return this;
		}
		@Override
		@RosettaAttribute("noTouchRateObservationSequence0")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setNoTouchRateObservationSequence0(NoTouchRateObservationSequence0 noTouchRateObservationSequence0) {
			this.noTouchRateObservationSequence0 = noTouchRateObservationSequence0==null?null:noTouchRateObservationSequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("upperBarrier")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setUpperBarrier(NoTouchUpperBarrierObservation upperBarrier) {
			this.upperBarrier = upperBarrier==null?null:upperBarrier.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("noTouchRateObservationSequence1")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setNoTouchRateObservationSequence1(NoTouchRateObservationSequence1 noTouchRateObservationSequence1) {
			this.noTouchRateObservationSequence1 = noTouchRateObservationSequence1==null?null:noTouchRateObservationSequence1.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("isExercisable")
		public NoTouchRateObservation.NoTouchRateObservationBuilder setIsExercisable(Boolean isExercisable) {
			this.isExercisable = isExercisable==null?null:isExercisable;
			return this;
		}
		
		@Override
		public NoTouchRateObservation build() {
			return new NoTouchRateObservation.NoTouchRateObservationImpl(this);
		}
		
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder prune() {
			if (noTouchRateObservationSequence0!=null && !noTouchRateObservationSequence0.prune().hasData()) noTouchRateObservationSequence0 = null;
			if (upperBarrier!=null && !upperBarrier.prune().hasData()) upperBarrier = null;
			if (noTouchRateObservationSequence1!=null && !noTouchRateObservationSequence1.prune().hasData()) noTouchRateObservationSequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getObservationStartDate()!=null) return true;
			if (getObservationEndDate()!=null) return true;
			if (getNoTouchRateObservationSequence0()!=null && getNoTouchRateObservationSequence0().hasData()) return true;
			if (getUpperBarrier()!=null && getUpperBarrier().hasData()) return true;
			if (getNoTouchRateObservationSequence1()!=null && getNoTouchRateObservationSequence1().hasData()) return true;
			if (getIsExercisable()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NoTouchRateObservation.NoTouchRateObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NoTouchRateObservation.NoTouchRateObservationBuilder o = (NoTouchRateObservation.NoTouchRateObservationBuilder) other;
			
			merger.mergeRosetta(getNoTouchRateObservationSequence0(), o.getNoTouchRateObservationSequence0(), this::setNoTouchRateObservationSequence0);
			merger.mergeRosetta(getUpperBarrier(), o.getUpperBarrier(), this::setUpperBarrier);
			merger.mergeRosetta(getNoTouchRateObservationSequence1(), o.getNoTouchRateObservationSequence1(), this::setNoTouchRateObservationSequence1);
			
			merger.mergeBasic(getObservationStartDate(), o.getObservationStartDate(), this::setObservationStartDate);
			merger.mergeBasic(getObservationEndDate(), o.getObservationEndDate(), this::setObservationEndDate);
			merger.mergeBasic(getIsExercisable(), o.getIsExercisable(), this::setIsExercisable);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NoTouchRateObservation _that = getType().cast(o);
		
			if (!Objects.equals(observationStartDate, _that.getObservationStartDate())) return false;
			if (!Objects.equals(observationEndDate, _that.getObservationEndDate())) return false;
			if (!Objects.equals(noTouchRateObservationSequence0, _that.getNoTouchRateObservationSequence0())) return false;
			if (!Objects.equals(upperBarrier, _that.getUpperBarrier())) return false;
			if (!Objects.equals(noTouchRateObservationSequence1, _that.getNoTouchRateObservationSequence1())) return false;
			if (!Objects.equals(isExercisable, _that.getIsExercisable())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (observationStartDate != null ? observationStartDate.hashCode() : 0);
			_result = 31 * _result + (observationEndDate != null ? observationEndDate.hashCode() : 0);
			_result = 31 * _result + (noTouchRateObservationSequence0 != null ? noTouchRateObservationSequence0.hashCode() : 0);
			_result = 31 * _result + (upperBarrier != null ? upperBarrier.hashCode() : 0);
			_result = 31 * _result + (noTouchRateObservationSequence1 != null ? noTouchRateObservationSequence1.hashCode() : 0);
			_result = 31 * _result + (isExercisable != null ? isExercisable.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NoTouchRateObservationBuilder {" +
				"observationStartDate=" + this.observationStartDate + ", " +
				"observationEndDate=" + this.observationEndDate + ", " +
				"noTouchRateObservationSequence0=" + this.noTouchRateObservationSequence0 + ", " +
				"upperBarrier=" + this.upperBarrier + ", " +
				"noTouchRateObservationSequence1=" + this.noTouchRateObservationSequence1 + ", " +
				"isExercisable=" + this.isExercisable +
			'}';
		}
	}
}

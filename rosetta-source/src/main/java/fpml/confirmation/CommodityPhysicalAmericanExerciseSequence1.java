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
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1BuilderImpl;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Impl;
import fpml.confirmation.CommodityRelativeExpirationDates;
import fpml.confirmation.meta.CommodityPhysicalAmericanExerciseSequence1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityPhysicalAmericanExerciseSequence1", builder=CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1BuilderImpl.class, version="${project.version}")
public interface CommodityPhysicalAmericanExerciseSequence1 extends RosettaModelObject {

	CommodityPhysicalAmericanExerciseSequence1Meta metaData = new CommodityPhysicalAmericanExerciseSequence1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day(s) of the exercise period(s) for an American-style option where it is relative to the occurrence of an external event.
	 */
	CommodityRelativeExpirationDates getRelativeCommencementDates();
	/**
	 * The Expiration Date(s) of an American-style option where it is relative to the occurrence of an external event.
	 */
	CommodityRelativeExpirationDates getRelativeExpirationDates();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalAmericanExerciseSequence1 build();
	
	CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder toBuilder();
	
	static CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder builder() {
		return new CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalAmericanExerciseSequence1> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalAmericanExerciseSequence1> getType() {
		return CommodityPhysicalAmericanExerciseSequence1.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("relativeCommencementDates"), processor, CommodityRelativeExpirationDates.class, getRelativeCommencementDates());
		processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.class, getRelativeExpirationDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalAmericanExerciseSequence1Builder extends CommodityPhysicalAmericanExerciseSequence1, RosettaModelObjectBuilder {
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeCommencementDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeCommencementDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates();
		CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates();
		CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder setRelativeCommencementDates(CommodityRelativeExpirationDates relativeCommencementDates);
		CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder setRelativeExpirationDates(CommodityRelativeExpirationDates relativeExpirationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("relativeCommencementDates"), processor, CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder.class, getRelativeCommencementDates());
			processRosetta(path.newSubPath("relativeExpirationDates"), processor, CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder.class, getRelativeExpirationDates());
		}
		

		CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalAmericanExerciseSequence1  ***********************/
	class CommodityPhysicalAmericanExerciseSequence1Impl implements CommodityPhysicalAmericanExerciseSequence1 {
		private final CommodityRelativeExpirationDates relativeCommencementDates;
		private final CommodityRelativeExpirationDates relativeExpirationDates;
		
		protected CommodityPhysicalAmericanExerciseSequence1Impl(CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder builder) {
			this.relativeCommencementDates = ofNullable(builder.getRelativeCommencementDates()).map(f->f.build()).orElse(null);
			this.relativeExpirationDates = ofNullable(builder.getRelativeExpirationDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("relativeCommencementDates")
		public CommodityRelativeExpirationDates getRelativeCommencementDates() {
			return relativeCommencementDates;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence1 build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder toBuilder() {
			CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder builder) {
			ofNullable(getRelativeCommencementDates()).ifPresent(builder::setRelativeCommencementDates);
			ofNullable(getRelativeExpirationDates()).ifPresent(builder::setRelativeExpirationDates);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalAmericanExerciseSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(relativeCommencementDates, _that.getRelativeCommencementDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativeCommencementDates != null ? relativeCommencementDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseSequence1 {" +
				"relativeCommencementDates=" + this.relativeCommencementDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalAmericanExerciseSequence1  ***********************/
	class CommodityPhysicalAmericanExerciseSequence1BuilderImpl implements CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder {
	
		protected CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder relativeCommencementDates;
		protected CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder relativeExpirationDates;
	
		public CommodityPhysicalAmericanExerciseSequence1BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("relativeCommencementDates")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeCommencementDates() {
			return relativeCommencementDates;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeCommencementDates() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder result;
			if (relativeCommencementDates!=null) {
				result = relativeCommencementDates;
			}
			else {
				result = relativeCommencementDates = CommodityRelativeExpirationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getRelativeExpirationDates() {
			return relativeExpirationDates;
		}
		
		@Override
		public CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder getOrCreateRelativeExpirationDates() {
			CommodityRelativeExpirationDates.CommodityRelativeExpirationDatesBuilder result;
			if (relativeExpirationDates!=null) {
				result = relativeExpirationDates;
			}
			else {
				result = relativeExpirationDates = CommodityRelativeExpirationDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("relativeCommencementDates")
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder setRelativeCommencementDates(CommodityRelativeExpirationDates relativeCommencementDates) {
			this.relativeCommencementDates = relativeCommencementDates==null?null:relativeCommencementDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("relativeExpirationDates")
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder setRelativeExpirationDates(CommodityRelativeExpirationDates relativeExpirationDates) {
			this.relativeExpirationDates = relativeExpirationDates==null?null:relativeExpirationDates.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence1 build() {
			return new CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Impl(this);
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder prune() {
			if (relativeCommencementDates!=null && !relativeCommencementDates.prune().hasData()) relativeCommencementDates = null;
			if (relativeExpirationDates!=null && !relativeExpirationDates.prune().hasData()) relativeExpirationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRelativeCommencementDates()!=null && getRelativeCommencementDates().hasData()) return true;
			if (getRelativeExpirationDates()!=null && getRelativeExpirationDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder o = (CommodityPhysicalAmericanExerciseSequence1.CommodityPhysicalAmericanExerciseSequence1Builder) other;
			
			merger.mergeRosetta(getRelativeCommencementDates(), o.getRelativeCommencementDates(), this::setRelativeCommencementDates);
			merger.mergeRosetta(getRelativeExpirationDates(), o.getRelativeExpirationDates(), this::setRelativeExpirationDates);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalAmericanExerciseSequence1 _that = getType().cast(o);
		
			if (!Objects.equals(relativeCommencementDates, _that.getRelativeCommencementDates())) return false;
			if (!Objects.equals(relativeExpirationDates, _that.getRelativeExpirationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (relativeCommencementDates != null ? relativeCommencementDates.hashCode() : 0);
			_result = 31 * _result + (relativeExpirationDates != null ? relativeExpirationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseSequence1Builder {" +
				"relativeCommencementDates=" + this.relativeCommencementDates + ", " +
				"relativeExpirationDates=" + this.relativeExpirationDates +
			'}';
		}
	}
}

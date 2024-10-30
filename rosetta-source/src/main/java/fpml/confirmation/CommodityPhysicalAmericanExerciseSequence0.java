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
import fpml.confirmation.AdjustableOrRelativeDates;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0BuilderImpl;
import fpml.confirmation.CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Impl;
import fpml.confirmation.meta.CommodityPhysicalAmericanExerciseSequence0Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPhysicalAmericanExerciseSequence0", builder=CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0BuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPhysicalAmericanExerciseSequence0 extends RosettaModelObject {

	CommodityPhysicalAmericanExerciseSequence0Meta metaData = new CommodityPhysicalAmericanExerciseSequence0Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The first day(s) of the exercise period(s) for an American-style option.
	 */
	AdjustableOrRelativeDates getCommencementDates();
	/**
	 * The Expiration Date(s) of an American-style option.
	 */
	AdjustableOrRelativeDates getExpirationDates();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalAmericanExerciseSequence0 build();
	
	CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder toBuilder();
	
	static CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder builder() {
		return new CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalAmericanExerciseSequence0> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalAmericanExerciseSequence0> getType() {
		return CommodityPhysicalAmericanExerciseSequence0.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("commencementDates"), processor, AdjustableOrRelativeDates.class, getCommencementDates());
		processRosetta(path.newSubPath("expirationDates"), processor, AdjustableOrRelativeDates.class, getExpirationDates());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalAmericanExerciseSequence0Builder extends CommodityPhysicalAmericanExerciseSequence0, RosettaModelObjectBuilder {
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateCommencementDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getCommencementDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExpirationDates();
		AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExpirationDates();
		CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder setCommencementDates(AdjustableOrRelativeDates commencementDates);
		CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder setExpirationDates(AdjustableOrRelativeDates expirationDates);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("commencementDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getCommencementDates());
			processRosetta(path.newSubPath("expirationDates"), processor, AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder.class, getExpirationDates());
		}
		

		CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalAmericanExerciseSequence0  ***********************/
	class CommodityPhysicalAmericanExerciseSequence0Impl implements CommodityPhysicalAmericanExerciseSequence0 {
		private final AdjustableOrRelativeDates commencementDates;
		private final AdjustableOrRelativeDates expirationDates;
		
		protected CommodityPhysicalAmericanExerciseSequence0Impl(CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder builder) {
			this.commencementDates = ofNullable(builder.getCommencementDates()).map(f->f.build()).orElse(null);
			this.expirationDates = ofNullable(builder.getExpirationDates()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commencementDates")
		public AdjustableOrRelativeDates getCommencementDates() {
			return commencementDates;
		}
		
		@Override
		@RosettaAttribute("expirationDates")
		public AdjustableOrRelativeDates getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence0 build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder toBuilder() {
			CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder builder) {
			ofNullable(getCommencementDates()).ifPresent(builder::setCommencementDates);
			ofNullable(getExpirationDates()).ifPresent(builder::setExpirationDates);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalAmericanExerciseSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(commencementDates, _that.getCommencementDates())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commencementDates != null ? commencementDates.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseSequence0 {" +
				"commencementDates=" + this.commencementDates + ", " +
				"expirationDates=" + this.expirationDates +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalAmericanExerciseSequence0  ***********************/
	class CommodityPhysicalAmericanExerciseSequence0BuilderImpl implements CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder {
	
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder commencementDates;
		protected AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder expirationDates;
	
		public CommodityPhysicalAmericanExerciseSequence0BuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commencementDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getCommencementDates() {
			return commencementDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateCommencementDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (commencementDates!=null) {
				result = commencementDates;
			}
			else {
				result = commencementDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("expirationDates")
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getExpirationDates() {
			return expirationDates;
		}
		
		@Override
		public AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder getOrCreateExpirationDates() {
			AdjustableOrRelativeDates.AdjustableOrRelativeDatesBuilder result;
			if (expirationDates!=null) {
				result = expirationDates;
			}
			else {
				result = expirationDates = AdjustableOrRelativeDates.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commencementDates")
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder setCommencementDates(AdjustableOrRelativeDates commencementDates) {
			this.commencementDates = commencementDates==null?null:commencementDates.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("expirationDates")
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder setExpirationDates(AdjustableOrRelativeDates expirationDates) {
			this.expirationDates = expirationDates==null?null:expirationDates.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence0 build() {
			return new CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Impl(this);
		}
		
		@Override
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder prune() {
			if (commencementDates!=null && !commencementDates.prune().hasData()) commencementDates = null;
			if (expirationDates!=null && !expirationDates.prune().hasData()) expirationDates = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCommencementDates()!=null && getCommencementDates().hasData()) return true;
			if (getExpirationDates()!=null && getExpirationDates().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder o = (CommodityPhysicalAmericanExerciseSequence0.CommodityPhysicalAmericanExerciseSequence0Builder) other;
			
			merger.mergeRosetta(getCommencementDates(), o.getCommencementDates(), this::setCommencementDates);
			merger.mergeRosetta(getExpirationDates(), o.getExpirationDates(), this::setExpirationDates);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityPhysicalAmericanExerciseSequence0 _that = getType().cast(o);
		
			if (!Objects.equals(commencementDates, _that.getCommencementDates())) return false;
			if (!Objects.equals(expirationDates, _that.getExpirationDates())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (commencementDates != null ? commencementDates.hashCode() : 0);
			_result = 31 * _result + (expirationDates != null ? expirationDates.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalAmericanExerciseSequence0Builder {" +
				"commencementDates=" + this.commencementDates + ", " +
				"expirationDates=" + this.expirationDates +
			'}';
		}
	}
}

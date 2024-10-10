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
import fpml.confirmation.AdjustableOrRelativeDate;
import fpml.confirmation.CommodityBarrier;
import fpml.confirmation.CommodityOptionFeaturesModel;
import fpml.confirmation.CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder;
import fpml.confirmation.CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilderImpl;
import fpml.confirmation.CommodityOptionFeaturesModel.CommodityOptionFeaturesModelImpl;
import fpml.confirmation.CommodityOptionFeaturesModelSequence;
import fpml.confirmation.meta.CommodityOptionFeaturesModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes additional features within the option.
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityOptionFeaturesModel", builder=CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilderImpl.class, version="${project.version}")
public interface CommodityOptionFeaturesModel extends RosettaModelObject {

	CommodityOptionFeaturesModelMeta metaData = new CommodityOptionFeaturesModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The effective date of the Commodity Option Transaction. Note that the Termination/Expiration Date should be specified in expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type, as applicable.
	 */
	AdjustableOrRelativeDate getEffectiveDate();
	/**
	 * Specifies the termination date of the Commodity Option Transaction. In some confirmations this will be indicated as the second date in &quot;Option Term&quot; or &quot;Term&quot;. Note: If provided, terminationDate should not be before specified expirationDate within the CommodityAmericanExercise type or the CommodityEuropeanExercise type.
	 */
	AdjustableOrRelativeDate getTerminationDate();
	CommodityOptionFeaturesModelSequence getCommodityOptionFeaturesModelSequence();
	/**
	 * Defines a commodity option barrier product feature.
	 */
	CommodityBarrier getBarrier();

	/*********************** Build Methods  ***********************/
	CommodityOptionFeaturesModel build();
	
	CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder toBuilder();
	
	static CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder builder() {
		return new CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityOptionFeaturesModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityOptionFeaturesModel> getType() {
		return CommodityOptionFeaturesModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.class, getEffectiveDate());
		processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.class, getTerminationDate());
		processRosetta(path.newSubPath("commodityOptionFeaturesModelSequence"), processor, CommodityOptionFeaturesModelSequence.class, getCommodityOptionFeaturesModelSequence());
		processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.class, getBarrier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityOptionFeaturesModelBuilder extends CommodityOptionFeaturesModel, RosettaModelObjectBuilder {
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate();
		AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate();
		CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder getOrCreateCommodityOptionFeaturesModelSequence();
		CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder getCommodityOptionFeaturesModelSequence();
		CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier();
		CommodityBarrier.CommodityBarrierBuilder getBarrier();
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate);
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate);
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setCommodityOptionFeaturesModelSequence(CommodityOptionFeaturesModelSequence commodityOptionFeaturesModelSequence);
		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setBarrier(CommodityBarrier barrier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("effectiveDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getEffectiveDate());
			processRosetta(path.newSubPath("terminationDate"), processor, AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder.class, getTerminationDate());
			processRosetta(path.newSubPath("commodityOptionFeaturesModelSequence"), processor, CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder.class, getCommodityOptionFeaturesModelSequence());
			processRosetta(path.newSubPath("barrier"), processor, CommodityBarrier.CommodityBarrierBuilder.class, getBarrier());
		}
		

		CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityOptionFeaturesModel  ***********************/
	class CommodityOptionFeaturesModelImpl implements CommodityOptionFeaturesModel {
		private final AdjustableOrRelativeDate effectiveDate;
		private final AdjustableOrRelativeDate terminationDate;
		private final CommodityOptionFeaturesModelSequence commodityOptionFeaturesModelSequence;
		private final CommodityBarrier barrier;
		
		protected CommodityOptionFeaturesModelImpl(CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder builder) {
			this.effectiveDate = ofNullable(builder.getEffectiveDate()).map(f->f.build()).orElse(null);
			this.terminationDate = ofNullable(builder.getTerminationDate()).map(f->f.build()).orElse(null);
			this.commodityOptionFeaturesModelSequence = ofNullable(builder.getCommodityOptionFeaturesModelSequence()).map(f->f.build()).orElse(null);
			this.barrier = ofNullable(builder.getBarrier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		@RosettaAttribute("commodityOptionFeaturesModelSequence")
		public CommodityOptionFeaturesModelSequence getCommodityOptionFeaturesModelSequence() {
			return commodityOptionFeaturesModelSequence;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public CommodityBarrier getBarrier() {
			return barrier;
		}
		
		@Override
		public CommodityOptionFeaturesModel build() {
			return this;
		}
		
		@Override
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder toBuilder() {
			CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder builder) {
			ofNullable(getEffectiveDate()).ifPresent(builder::setEffectiveDate);
			ofNullable(getTerminationDate()).ifPresent(builder::setTerminationDate);
			ofNullable(getCommodityOptionFeaturesModelSequence()).ifPresent(builder::setCommodityOptionFeaturesModelSequence);
			ofNullable(getBarrier()).ifPresent(builder::setBarrier);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(commodityOptionFeaturesModelSequence, _that.getCommodityOptionFeaturesModelSequence())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (commodityOptionFeaturesModelSequence != null ? commodityOptionFeaturesModelSequence.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionFeaturesModel {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"commodityOptionFeaturesModelSequence=" + this.commodityOptionFeaturesModelSequence + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityOptionFeaturesModel  ***********************/
	class CommodityOptionFeaturesModelBuilderImpl implements CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder {
	
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder effectiveDate;
		protected AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder terminationDate;
		protected CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder commodityOptionFeaturesModelSequence;
		protected CommodityBarrier.CommodityBarrierBuilder barrier;
	
		public CommodityOptionFeaturesModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("effectiveDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getEffectiveDate() {
			return effectiveDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateEffectiveDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (effectiveDate!=null) {
				result = effectiveDate;
			}
			else {
				result = effectiveDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("terminationDate")
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getTerminationDate() {
			return terminationDate;
		}
		
		@Override
		public AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder getOrCreateTerminationDate() {
			AdjustableOrRelativeDate.AdjustableOrRelativeDateBuilder result;
			if (terminationDate!=null) {
				result = terminationDate;
			}
			else {
				result = terminationDate = AdjustableOrRelativeDate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("commodityOptionFeaturesModelSequence")
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder getCommodityOptionFeaturesModelSequence() {
			return commodityOptionFeaturesModelSequence;
		}
		
		@Override
		public CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder getOrCreateCommodityOptionFeaturesModelSequence() {
			CommodityOptionFeaturesModelSequence.CommodityOptionFeaturesModelSequenceBuilder result;
			if (commodityOptionFeaturesModelSequence!=null) {
				result = commodityOptionFeaturesModelSequence;
			}
			else {
				result = commodityOptionFeaturesModelSequence = CommodityOptionFeaturesModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("barrier")
		public CommodityBarrier.CommodityBarrierBuilder getBarrier() {
			return barrier;
		}
		
		@Override
		public CommodityBarrier.CommodityBarrierBuilder getOrCreateBarrier() {
			CommodityBarrier.CommodityBarrierBuilder result;
			if (barrier!=null) {
				result = barrier;
			}
			else {
				result = barrier = CommodityBarrier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("effectiveDate")
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setEffectiveDate(AdjustableOrRelativeDate effectiveDate) {
			this.effectiveDate = effectiveDate==null?null:effectiveDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("terminationDate")
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setTerminationDate(AdjustableOrRelativeDate terminationDate) {
			this.terminationDate = terminationDate==null?null:terminationDate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("commodityOptionFeaturesModelSequence")
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setCommodityOptionFeaturesModelSequence(CommodityOptionFeaturesModelSequence commodityOptionFeaturesModelSequence) {
			this.commodityOptionFeaturesModelSequence = commodityOptionFeaturesModelSequence==null?null:commodityOptionFeaturesModelSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("barrier")
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder setBarrier(CommodityBarrier barrier) {
			this.barrier = barrier==null?null:barrier.toBuilder();
			return this;
		}
		
		@Override
		public CommodityOptionFeaturesModel build() {
			return new CommodityOptionFeaturesModel.CommodityOptionFeaturesModelImpl(this);
		}
		
		@Override
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder prune() {
			if (effectiveDate!=null && !effectiveDate.prune().hasData()) effectiveDate = null;
			if (terminationDate!=null && !terminationDate.prune().hasData()) terminationDate = null;
			if (commodityOptionFeaturesModelSequence!=null && !commodityOptionFeaturesModelSequence.prune().hasData()) commodityOptionFeaturesModelSequence = null;
			if (barrier!=null && !barrier.prune().hasData()) barrier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getEffectiveDate()!=null && getEffectiveDate().hasData()) return true;
			if (getTerminationDate()!=null && getTerminationDate().hasData()) return true;
			if (getCommodityOptionFeaturesModelSequence()!=null && getCommodityOptionFeaturesModelSequence().hasData()) return true;
			if (getBarrier()!=null && getBarrier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder o = (CommodityOptionFeaturesModel.CommodityOptionFeaturesModelBuilder) other;
			
			merger.mergeRosetta(getEffectiveDate(), o.getEffectiveDate(), this::setEffectiveDate);
			merger.mergeRosetta(getTerminationDate(), o.getTerminationDate(), this::setTerminationDate);
			merger.mergeRosetta(getCommodityOptionFeaturesModelSequence(), o.getCommodityOptionFeaturesModelSequence(), this::setCommodityOptionFeaturesModelSequence);
			merger.mergeRosetta(getBarrier(), o.getBarrier(), this::setBarrier);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityOptionFeaturesModel _that = getType().cast(o);
		
			if (!Objects.equals(effectiveDate, _that.getEffectiveDate())) return false;
			if (!Objects.equals(terminationDate, _that.getTerminationDate())) return false;
			if (!Objects.equals(commodityOptionFeaturesModelSequence, _that.getCommodityOptionFeaturesModelSequence())) return false;
			if (!Objects.equals(barrier, _that.getBarrier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (effectiveDate != null ? effectiveDate.hashCode() : 0);
			_result = 31 * _result + (terminationDate != null ? terminationDate.hashCode() : 0);
			_result = 31 * _result + (commodityOptionFeaturesModelSequence != null ? commodityOptionFeaturesModelSequence.hashCode() : 0);
			_result = 31 * _result + (barrier != null ? barrier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityOptionFeaturesModelBuilder {" +
				"effectiveDate=" + this.effectiveDate + ", " +
				"terminationDate=" + this.terminationDate + ", " +
				"commodityOptionFeaturesModelSequence=" + this.commodityOptionFeaturesModelSequence + ", " +
				"barrier=" + this.barrier +
			'}';
		}
	}
}

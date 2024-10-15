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
import fpml.confirmation.CommodityFxSequenceSequenceSequence;
import fpml.confirmation.CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder;
import fpml.confirmation.CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilderImpl;
import fpml.confirmation.CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceImpl;
import fpml.confirmation.DaysModel;
import fpml.confirmation.LagOrReferenceModel;
import fpml.confirmation.meta.CommodityFxSequenceSequenceSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityFxSequenceSequenceSequence", builder=CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface CommodityFxSequenceSequenceSequence extends RosettaModelObject {

	CommodityFxSequenceSequenceSequenceMeta metaData = new CommodityFxSequenceSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	DaysModel getDaysModel();
	LagOrReferenceModel getLagOrReferenceModel();

	/*********************** Build Methods  ***********************/
	CommodityFxSequenceSequenceSequence build();
	
	CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder toBuilder();
	
	static CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder builder() {
		return new CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityFxSequenceSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityFxSequenceSequenceSequence> getType() {
		return CommodityFxSequenceSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("daysModel"), processor, DaysModel.class, getDaysModel());
		processRosetta(path.newSubPath("lagOrReferenceModel"), processor, LagOrReferenceModel.class, getLagOrReferenceModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityFxSequenceSequenceSequenceBuilder extends CommodityFxSequenceSequenceSequence, RosettaModelObjectBuilder {
		DaysModel.DaysModelBuilder getOrCreateDaysModel();
		DaysModel.DaysModelBuilder getDaysModel();
		LagOrReferenceModel.LagOrReferenceModelBuilder getOrCreateLagOrReferenceModel();
		LagOrReferenceModel.LagOrReferenceModelBuilder getLagOrReferenceModel();
		CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder setDaysModel(DaysModel daysModel);
		CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder setLagOrReferenceModel(LagOrReferenceModel lagOrReferenceModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("daysModel"), processor, DaysModel.DaysModelBuilder.class, getDaysModel());
			processRosetta(path.newSubPath("lagOrReferenceModel"), processor, LagOrReferenceModel.LagOrReferenceModelBuilder.class, getLagOrReferenceModel());
		}
		

		CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityFxSequenceSequenceSequence  ***********************/
	class CommodityFxSequenceSequenceSequenceImpl implements CommodityFxSequenceSequenceSequence {
		private final DaysModel daysModel;
		private final LagOrReferenceModel lagOrReferenceModel;
		
		protected CommodityFxSequenceSequenceSequenceImpl(CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder builder) {
			this.daysModel = ofNullable(builder.getDaysModel()).map(f->f.build()).orElse(null);
			this.lagOrReferenceModel = ofNullable(builder.getLagOrReferenceModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("daysModel")
		public DaysModel getDaysModel() {
			return daysModel;
		}
		
		@Override
		@RosettaAttribute("lagOrReferenceModel")
		public LagOrReferenceModel getLagOrReferenceModel() {
			return lagOrReferenceModel;
		}
		
		@Override
		public CommodityFxSequenceSequenceSequence build() {
			return this;
		}
		
		@Override
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder toBuilder() {
			CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder builder) {
			ofNullable(getDaysModel()).ifPresent(builder::setDaysModel);
			ofNullable(getLagOrReferenceModel()).ifPresent(builder::setLagOrReferenceModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequenceSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(daysModel, _that.getDaysModel())) return false;
			if (!Objects.equals(lagOrReferenceModel, _that.getLagOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysModel != null ? daysModel.hashCode() : 0);
			_result = 31 * _result + (lagOrReferenceModel != null ? lagOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequenceSequenceSequence {" +
				"daysModel=" + this.daysModel + ", " +
				"lagOrReferenceModel=" + this.lagOrReferenceModel +
			'}';
		}
	}

	/*********************** Builder Implementation of CommodityFxSequenceSequenceSequence  ***********************/
	class CommodityFxSequenceSequenceSequenceBuilderImpl implements CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder {
	
		protected DaysModel.DaysModelBuilder daysModel;
		protected LagOrReferenceModel.LagOrReferenceModelBuilder lagOrReferenceModel;
	
		public CommodityFxSequenceSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("daysModel")
		public DaysModel.DaysModelBuilder getDaysModel() {
			return daysModel;
		}
		
		@Override
		public DaysModel.DaysModelBuilder getOrCreateDaysModel() {
			DaysModel.DaysModelBuilder result;
			if (daysModel!=null) {
				result = daysModel;
			}
			else {
				result = daysModel = DaysModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("lagOrReferenceModel")
		public LagOrReferenceModel.LagOrReferenceModelBuilder getLagOrReferenceModel() {
			return lagOrReferenceModel;
		}
		
		@Override
		public LagOrReferenceModel.LagOrReferenceModelBuilder getOrCreateLagOrReferenceModel() {
			LagOrReferenceModel.LagOrReferenceModelBuilder result;
			if (lagOrReferenceModel!=null) {
				result = lagOrReferenceModel;
			}
			else {
				result = lagOrReferenceModel = LagOrReferenceModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("daysModel")
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder setDaysModel(DaysModel daysModel) {
			this.daysModel = daysModel==null?null:daysModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("lagOrReferenceModel")
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder setLagOrReferenceModel(LagOrReferenceModel lagOrReferenceModel) {
			this.lagOrReferenceModel = lagOrReferenceModel==null?null:lagOrReferenceModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityFxSequenceSequenceSequence build() {
			return new CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceImpl(this);
		}
		
		@Override
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder prune() {
			if (daysModel!=null && !daysModel.prune().hasData()) daysModel = null;
			if (lagOrReferenceModel!=null && !lagOrReferenceModel.prune().hasData()) lagOrReferenceModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDaysModel()!=null && getDaysModel().hasData()) return true;
			if (getLagOrReferenceModel()!=null && getLagOrReferenceModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder o = (CommodityFxSequenceSequenceSequence.CommodityFxSequenceSequenceSequenceBuilder) other;
			
			merger.mergeRosetta(getDaysModel(), o.getDaysModel(), this::setDaysModel);
			merger.mergeRosetta(getLagOrReferenceModel(), o.getLagOrReferenceModel(), this::setLagOrReferenceModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CommodityFxSequenceSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(daysModel, _that.getDaysModel())) return false;
			if (!Objects.equals(lagOrReferenceModel, _that.getLagOrReferenceModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (daysModel != null ? daysModel.hashCode() : 0);
			_result = 31 * _result + (lagOrReferenceModel != null ? lagOrReferenceModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityFxSequenceSequenceSequenceBuilder {" +
				"daysModel=" + this.daysModel + ", " +
				"lagOrReferenceModel=" + this.lagOrReferenceModel +
			'}';
		}
	}
}

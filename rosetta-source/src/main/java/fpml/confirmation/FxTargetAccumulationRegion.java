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
import fpml.confirmation.FxTargetAccumulationRegion;
import fpml.confirmation.FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder;
import fpml.confirmation.FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl;
import fpml.confirmation.FxTargetAccumulationRegion.FxTargetAccumulationRegionImpl;
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.meta.FxTargetAccumulationRegionMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxTargetAccumulationRegion", builder=FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxTargetAccumulationRegion extends RosettaModelObject {

	FxTargetAccumulationRegionMeta metaData = new FxTargetAccumulationRegionMeta();

	/*********************** Getter Methods  ***********************/
	FxTargetRegionBoundModel getFxTargetRegionBoundModel();
	/**
	 * This is the factor that increases gain, not notional. Used to support Accelerated TARFs.
	 */
	BigDecimal getMultiplier();

	/*********************** Build Methods  ***********************/
	FxTargetAccumulationRegion build();
	
	FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder();
	
	static FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder() {
		return new FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetAccumulationRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetAccumulationRegion> getType() {
		return FxTargetAccumulationRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxTargetRegionBoundModel"), processor, FxTargetRegionBoundModel.class, getFxTargetRegionBoundModel());
		processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetAccumulationRegionBuilder extends FxTargetAccumulationRegion, RosettaModelObjectBuilder {
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getOrCreateFxTargetRegionBoundModel();
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getFxTargetRegionBoundModel();
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setFxTargetRegionBoundModel(FxTargetRegionBoundModel fxTargetRegionBoundModel);
		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setMultiplier(BigDecimal multiplier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxTargetRegionBoundModel"), processor, FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder.class, getFxTargetRegionBoundModel());
			processor.processBasic(path.newSubPath("multiplier"), BigDecimal.class, getMultiplier(), this);
		}
		

		FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetAccumulationRegion  ***********************/
	class FxTargetAccumulationRegionImpl implements FxTargetAccumulationRegion {
		private final FxTargetRegionBoundModel fxTargetRegionBoundModel;
		private final BigDecimal multiplier;
		
		protected FxTargetAccumulationRegionImpl(FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder) {
			this.fxTargetRegionBoundModel = ofNullable(builder.getFxTargetRegionBoundModel()).map(f->f.build()).orElse(null);
			this.multiplier = builder.getMultiplier();
		}
		
		@Override
		@RosettaAttribute("fxTargetRegionBoundModel")
		public FxTargetRegionBoundModel getFxTargetRegionBoundModel() {
			return fxTargetRegionBoundModel;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		public FxTargetAccumulationRegion build() {
			return this;
		}
		
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder() {
			FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder builder) {
			ofNullable(getFxTargetRegionBoundModel()).ifPresent(builder::setFxTargetRegionBoundModel);
			ofNullable(getMultiplier()).ifPresent(builder::setMultiplier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetAccumulationRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetRegionBoundModel, _that.getFxTargetRegionBoundModel())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxTargetRegionBoundModel != null ? fxTargetRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetAccumulationRegion {" +
				"fxTargetRegionBoundModel=" + this.fxTargetRegionBoundModel + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetAccumulationRegion  ***********************/
	class FxTargetAccumulationRegionBuilderImpl implements FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder {
	
		protected FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder fxTargetRegionBoundModel;
		protected BigDecimal multiplier;
	
		public FxTargetAccumulationRegionBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxTargetRegionBoundModel")
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getFxTargetRegionBoundModel() {
			return fxTargetRegionBoundModel;
		}
		
		@Override
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getOrCreateFxTargetRegionBoundModel() {
			FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder result;
			if (fxTargetRegionBoundModel!=null) {
				result = fxTargetRegionBoundModel;
			}
			else {
				result = fxTargetRegionBoundModel = FxTargetRegionBoundModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("multiplier")
		public BigDecimal getMultiplier() {
			return multiplier;
		}
		
		@Override
		@RosettaAttribute("fxTargetRegionBoundModel")
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setFxTargetRegionBoundModel(FxTargetRegionBoundModel fxTargetRegionBoundModel) {
			this.fxTargetRegionBoundModel = fxTargetRegionBoundModel==null?null:fxTargetRegionBoundModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("multiplier")
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder setMultiplier(BigDecimal multiplier) {
			this.multiplier = multiplier==null?null:multiplier;
			return this;
		}
		
		@Override
		public FxTargetAccumulationRegion build() {
			return new FxTargetAccumulationRegion.FxTargetAccumulationRegionImpl(this);
		}
		
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder prune() {
			if (fxTargetRegionBoundModel!=null && !fxTargetRegionBoundModel.prune().hasData()) fxTargetRegionBoundModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxTargetRegionBoundModel()!=null && getFxTargetRegionBoundModel().hasData()) return true;
			if (getMultiplier()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder o = (FxTargetAccumulationRegion.FxTargetAccumulationRegionBuilder) other;
			
			merger.mergeRosetta(getFxTargetRegionBoundModel(), o.getFxTargetRegionBoundModel(), this::setFxTargetRegionBoundModel);
			
			merger.mergeBasic(getMultiplier(), o.getMultiplier(), this::setMultiplier);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetAccumulationRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetRegionBoundModel, _that.getFxTargetRegionBoundModel())) return false;
			if (!Objects.equals(multiplier, _that.getMultiplier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxTargetRegionBoundModel != null ? fxTargetRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (multiplier != null ? multiplier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetAccumulationRegionBuilder {" +
				"fxTargetRegionBoundModel=" + this.fxTargetRegionBoundModel + ", " +
				"multiplier=" + this.multiplier +
			'}';
		}
	}
}

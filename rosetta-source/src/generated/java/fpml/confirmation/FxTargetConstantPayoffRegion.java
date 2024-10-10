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
import fpml.confirmation.FxTargetConstantPayoff;
import fpml.confirmation.FxTargetConstantPayoffRegion;
import fpml.confirmation.FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder;
import fpml.confirmation.FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl;
import fpml.confirmation.FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionImpl;
import fpml.confirmation.FxTargetPayoffRegion;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilder;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl;
import fpml.confirmation.FxTargetPayoffRegion.FxTargetPayoffRegionImpl;
import fpml.confirmation.FxTargetPhysicalSettlement;
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.meta.FxTargetConstantPayoffRegionMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A fixing region in which the payoff is a constant value (a binary|digital payoff, or zero).
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetConstantPayoffRegion", builder=FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl.class, version="${project.version}")
public interface FxTargetConstantPayoffRegion extends FxTargetPayoffRegion {

	FxTargetConstantPayoffRegionMeta metaData = new FxTargetConstantPayoffRegionMeta();

	/*********************** Getter Methods  ***********************/
	FxTargetRegionBoundModel getFxTargetRegionBoundModel();
	/**
	 * A binary|digital payoff, expressed either as a cash payment, or a (non-zero) fixing adjustment.
	 */
	FxTargetConstantPayoff getPayoff();
	FxTargetPhysicalSettlement getPhysicalSettlement();

	/*********************** Build Methods  ***********************/
	FxTargetConstantPayoffRegion build();
	
	FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder();
	
	static FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder() {
		return new FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConstantPayoffRegion> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetConstantPayoffRegion> getType() {
		return FxTargetConstantPayoffRegion.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("fxTargetRegionBoundModel"), processor, FxTargetRegionBoundModel.class, getFxTargetRegionBoundModel());
		processRosetta(path.newSubPath("payoff"), processor, FxTargetConstantPayoff.class, getPayoff());
		processRosetta(path.newSubPath("physicalSettlement"), processor, FxTargetPhysicalSettlement.class, getPhysicalSettlement());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConstantPayoffRegionBuilder extends FxTargetConstantPayoffRegion, FxTargetPayoffRegion.FxTargetPayoffRegionBuilder {
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getOrCreateFxTargetRegionBoundModel();
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder getFxTargetRegionBoundModel();
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getOrCreatePayoff();
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getPayoff();
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getOrCreatePhysicalSettlement();
		FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getPhysicalSettlement();
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setId(String id);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setFxTargetRegionBoundModel(FxTargetRegionBoundModel fxTargetRegionBoundModel);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPayoff(FxTargetConstantPayoff payoff);
		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPhysicalSettlement(FxTargetPhysicalSettlement physicalSettlement);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("fxTargetRegionBoundModel"), processor, FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder.class, getFxTargetRegionBoundModel());
			processRosetta(path.newSubPath("payoff"), processor, FxTargetConstantPayoff.FxTargetConstantPayoffBuilder.class, getPayoff());
			processRosetta(path.newSubPath("physicalSettlement"), processor, FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder.class, getPhysicalSettlement());
		}
		

		FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConstantPayoffRegion  ***********************/
	class FxTargetConstantPayoffRegionImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionImpl implements FxTargetConstantPayoffRegion {
		private final FxTargetRegionBoundModel fxTargetRegionBoundModel;
		private final FxTargetConstantPayoff payoff;
		private final FxTargetPhysicalSettlement physicalSettlement;
		
		protected FxTargetConstantPayoffRegionImpl(FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder) {
			super(builder);
			this.fxTargetRegionBoundModel = ofNullable(builder.getFxTargetRegionBoundModel()).map(f->f.build()).orElse(null);
			this.payoff = ofNullable(builder.getPayoff()).map(f->f.build()).orElse(null);
			this.physicalSettlement = ofNullable(builder.getPhysicalSettlement()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("fxTargetRegionBoundModel")
		public FxTargetRegionBoundModel getFxTargetRegionBoundModel() {
			return fxTargetRegionBoundModel;
		}
		
		@Override
		@RosettaAttribute("payoff")
		public FxTargetConstantPayoff getPayoff() {
			return payoff;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public FxTargetPhysicalSettlement getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public FxTargetConstantPayoffRegion build() {
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder() {
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFxTargetRegionBoundModel()).ifPresent(builder::setFxTargetRegionBoundModel);
			ofNullable(getPayoff()).ifPresent(builder::setPayoff);
			ofNullable(getPhysicalSettlement()).ifPresent(builder::setPhysicalSettlement);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetConstantPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetRegionBoundModel, _that.getFxTargetRegionBoundModel())) return false;
			if (!Objects.equals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxTargetRegionBoundModel != null ? fxTargetRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffRegion {" +
				"fxTargetRegionBoundModel=" + this.fxTargetRegionBoundModel + ", " +
				"payoff=" + this.payoff + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of FxTargetConstantPayoffRegion  ***********************/
	class FxTargetConstantPayoffRegionBuilderImpl extends FxTargetPayoffRegion.FxTargetPayoffRegionBuilderImpl  implements FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder {
	
		protected FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder fxTargetRegionBoundModel;
		protected FxTargetConstantPayoff.FxTargetConstantPayoffBuilder payoff;
		protected FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder physicalSettlement;
	
		public FxTargetConstantPayoffRegionBuilderImpl() {
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
		@RosettaAttribute("payoff")
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getPayoff() {
			return payoff;
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder getOrCreatePayoff() {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder result;
			if (payoff!=null) {
				result = payoff;
			}
			else {
				result = payoff = FxTargetConstantPayoff.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("physicalSettlement")
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getPhysicalSettlement() {
			return physicalSettlement;
		}
		
		@Override
		public FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder getOrCreatePhysicalSettlement() {
			FxTargetPhysicalSettlement.FxTargetPhysicalSettlementBuilder result;
			if (physicalSettlement!=null) {
				result = physicalSettlement;
			}
			else {
				result = physicalSettlement = FxTargetPhysicalSettlement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetRegionBoundModel")
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setFxTargetRegionBoundModel(FxTargetRegionBoundModel fxTargetRegionBoundModel) {
			this.fxTargetRegionBoundModel = fxTargetRegionBoundModel==null?null:fxTargetRegionBoundModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("payoff")
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPayoff(FxTargetConstantPayoff payoff) {
			this.payoff = payoff==null?null:payoff.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("physicalSettlement")
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder setPhysicalSettlement(FxTargetPhysicalSettlement physicalSettlement) {
			this.physicalSettlement = physicalSettlement==null?null:physicalSettlement.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetConstantPayoffRegion build() {
			return new FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionImpl(this);
		}
		
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder prune() {
			super.prune();
			if (fxTargetRegionBoundModel!=null && !fxTargetRegionBoundModel.prune().hasData()) fxTargetRegionBoundModel = null;
			if (payoff!=null && !payoff.prune().hasData()) payoff = null;
			if (physicalSettlement!=null && !physicalSettlement.prune().hasData()) physicalSettlement = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFxTargetRegionBoundModel()!=null && getFxTargetRegionBoundModel().hasData()) return true;
			if (getPayoff()!=null && getPayoff().hasData()) return true;
			if (getPhysicalSettlement()!=null && getPhysicalSettlement().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder o = (FxTargetConstantPayoffRegion.FxTargetConstantPayoffRegionBuilder) other;
			
			merger.mergeRosetta(getFxTargetRegionBoundModel(), o.getFxTargetRegionBoundModel(), this::setFxTargetRegionBoundModel);
			merger.mergeRosetta(getPayoff(), o.getPayoff(), this::setPayoff);
			merger.mergeRosetta(getPhysicalSettlement(), o.getPhysicalSettlement(), this::setPhysicalSettlement);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxTargetConstantPayoffRegion _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetRegionBoundModel, _that.getFxTargetRegionBoundModel())) return false;
			if (!Objects.equals(payoff, _that.getPayoff())) return false;
			if (!Objects.equals(physicalSettlement, _that.getPhysicalSettlement())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fxTargetRegionBoundModel != null ? fxTargetRegionBoundModel.hashCode() : 0);
			_result = 31 * _result + (payoff != null ? payoff.hashCode() : 0);
			_result = 31 * _result + (physicalSettlement != null ? physicalSettlement.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffRegionBuilder {" +
				"fxTargetRegionBoundModel=" + this.fxTargetRegionBoundModel + ", " +
				"payoff=" + this.payoff + ", " +
				"physicalSettlement=" + this.physicalSettlement +
			'}' + " " + super.toString();
		}
	}
}

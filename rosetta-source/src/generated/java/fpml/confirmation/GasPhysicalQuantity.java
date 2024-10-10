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
import fpml.confirmation.CommodityFixedPhysicalQuantityModel;
import fpml.confirmation.CommodityPhysicalQuantityBase;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl;
import fpml.confirmation.GasPhysicalQuantity;
import fpml.confirmation.GasPhysicalQuantity.GasPhysicalQuantityBuilder;
import fpml.confirmation.GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl;
import fpml.confirmation.GasPhysicalQuantity.GasPhysicalQuantityImpl;
import fpml.confirmation.GasPhysicalQuantitySequence;
import fpml.confirmation.meta.GasPhysicalQuantityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The quantity of gas to be delivered.
 * @version ${project.version}
 */
@RosettaDataType(value="GasPhysicalQuantity", builder=GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl.class, version="${project.version}")
public interface GasPhysicalQuantity extends CommodityPhysicalQuantityBase {

	GasPhysicalQuantityMeta metaData = new GasPhysicalQuantityMeta();

	/*********************** Getter Methods  ***********************/
	CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel();
	GasPhysicalQuantitySequence getGasPhysicalQuantitySequence();

	/*********************** Build Methods  ***********************/
	GasPhysicalQuantity build();
	
	GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder();
	
	static GasPhysicalQuantity.GasPhysicalQuantityBuilder builder() {
		return new GasPhysicalQuantity.GasPhysicalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasPhysicalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasPhysicalQuantity> getType() {
		return GasPhysicalQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.class, getCommodityFixedPhysicalQuantityModel());
		processRosetta(path.newSubPath("gasPhysicalQuantitySequence"), processor, GasPhysicalQuantitySequence.class, getGasPhysicalQuantitySequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasPhysicalQuantityBuilder extends GasPhysicalQuantity, CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel();
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder getOrCreateGasPhysicalQuantitySequence();
		GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder getGasPhysicalQuantitySequence();
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setId(String id);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel);
		GasPhysicalQuantity.GasPhysicalQuantityBuilder setGasPhysicalQuantitySequence(GasPhysicalQuantitySequence gasPhysicalQuantitySequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder.class, getCommodityFixedPhysicalQuantityModel());
			processRosetta(path.newSubPath("gasPhysicalQuantitySequence"), processor, GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder.class, getGasPhysicalQuantitySequence());
		}
		

		GasPhysicalQuantity.GasPhysicalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of GasPhysicalQuantity  ***********************/
	class GasPhysicalQuantityImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl implements GasPhysicalQuantity {
		private final CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel;
		private final GasPhysicalQuantitySequence gasPhysicalQuantitySequence;
		
		protected GasPhysicalQuantityImpl(GasPhysicalQuantity.GasPhysicalQuantityBuilder builder) {
			super(builder);
			this.commodityFixedPhysicalQuantityModel = ofNullable(builder.getCommodityFixedPhysicalQuantityModel()).map(f->f.build()).orElse(null);
			this.gasPhysicalQuantitySequence = ofNullable(builder.getGasPhysicalQuantitySequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		@RosettaAttribute("gasPhysicalQuantitySequence")
		public GasPhysicalQuantitySequence getGasPhysicalQuantitySequence() {
			return gasPhysicalQuantitySequence;
		}
		
		@Override
		public GasPhysicalQuantity build() {
			return this;
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder() {
			GasPhysicalQuantity.GasPhysicalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasPhysicalQuantity.GasPhysicalQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityFixedPhysicalQuantityModel()).ifPresent(builder::setCommodityFixedPhysicalQuantityModel);
			ofNullable(getGasPhysicalQuantitySequence()).ifPresent(builder::setGasPhysicalQuantitySequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(gasPhysicalQuantitySequence, _that.getGasPhysicalQuantitySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (gasPhysicalQuantitySequence != null ? gasPhysicalQuantitySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantity {" +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"gasPhysicalQuantitySequence=" + this.gasPhysicalQuantitySequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of GasPhysicalQuantity  ***********************/
	class GasPhysicalQuantityBuilderImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl  implements GasPhysicalQuantity.GasPhysicalQuantityBuilder {
	
		protected CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder commodityFixedPhysicalQuantityModel;
		protected GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder gasPhysicalQuantitySequence;
	
		public GasPhysicalQuantityBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		public CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel() {
			CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder result;
			if (commodityFixedPhysicalQuantityModel!=null) {
				result = commodityFixedPhysicalQuantityModel;
			}
			else {
				result = commodityFixedPhysicalQuantityModel = CommodityFixedPhysicalQuantityModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("gasPhysicalQuantitySequence")
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder getGasPhysicalQuantitySequence() {
			return gasPhysicalQuantitySequence;
		}
		
		@Override
		public GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder getOrCreateGasPhysicalQuantitySequence() {
			GasPhysicalQuantitySequence.GasPhysicalQuantitySequenceBuilder result;
			if (gasPhysicalQuantitySequence!=null) {
				result = gasPhysicalQuantitySequence;
			}
			else {
				result = gasPhysicalQuantitySequence = GasPhysicalQuantitySequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			this.commodityFixedPhysicalQuantityModel = commodityFixedPhysicalQuantityModel==null?null:commodityFixedPhysicalQuantityModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("gasPhysicalQuantitySequence")
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder setGasPhysicalQuantitySequence(GasPhysicalQuantitySequence gasPhysicalQuantitySequence) {
			this.gasPhysicalQuantitySequence = gasPhysicalQuantitySequence==null?null:gasPhysicalQuantitySequence.toBuilder();
			return this;
		}
		
		@Override
		public GasPhysicalQuantity build() {
			return new GasPhysicalQuantity.GasPhysicalQuantityImpl(this);
		}
		
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder prune() {
			super.prune();
			if (commodityFixedPhysicalQuantityModel!=null && !commodityFixedPhysicalQuantityModel.prune().hasData()) commodityFixedPhysicalQuantityModel = null;
			if (gasPhysicalQuantitySequence!=null && !gasPhysicalQuantitySequence.prune().hasData()) gasPhysicalQuantitySequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityFixedPhysicalQuantityModel()!=null && getCommodityFixedPhysicalQuantityModel().hasData()) return true;
			if (getGasPhysicalQuantitySequence()!=null && getGasPhysicalQuantitySequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasPhysicalQuantity.GasPhysicalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			GasPhysicalQuantity.GasPhysicalQuantityBuilder o = (GasPhysicalQuantity.GasPhysicalQuantityBuilder) other;
			
			merger.mergeRosetta(getCommodityFixedPhysicalQuantityModel(), o.getCommodityFixedPhysicalQuantityModel(), this::setCommodityFixedPhysicalQuantityModel);
			merger.mergeRosetta(getGasPhysicalQuantitySequence(), o.getGasPhysicalQuantitySequence(), this::setGasPhysicalQuantitySequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			GasPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			if (!Objects.equals(gasPhysicalQuantitySequence, _that.getGasPhysicalQuantitySequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			_result = 31 * _result + (gasPhysicalQuantitySequence != null ? gasPhysicalQuantitySequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasPhysicalQuantityBuilder {" +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel + ", " +
				"gasPhysicalQuantitySequence=" + this.gasPhysicalQuantitySequence +
			'}' + " " + super.toString();
		}
	}
}

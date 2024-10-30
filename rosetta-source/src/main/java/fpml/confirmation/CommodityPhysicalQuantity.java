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
import fpml.confirmation.CommodityPhysicalQuantity;
import fpml.confirmation.CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder;
import fpml.confirmation.CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl;
import fpml.confirmation.CommodityPhysicalQuantity.CommodityPhysicalQuantityImpl;
import fpml.confirmation.CommodityPhysicalQuantityBase;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl;
import fpml.confirmation.CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl;
import fpml.confirmation.meta.CommodityPhysicalQuantityMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the physical quantity of the commodity to be delivered.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CommodityPhysicalQuantity", builder=CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CommodityPhysicalQuantity extends CommodityPhysicalQuantityBase {

	CommodityPhysicalQuantityMeta metaData = new CommodityPhysicalQuantityMeta();

	/*********************** Getter Methods  ***********************/
	CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel();

	/*********************** Build Methods  ***********************/
	CommodityPhysicalQuantity build();
	
	CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder();
	
	static CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder() {
		return new CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityPhysicalQuantity> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityPhysicalQuantity> getType() {
		return CommodityPhysicalQuantity.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.class, getCommodityFixedPhysicalQuantityModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityPhysicalQuantityBuilder extends CommodityPhysicalQuantity, CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilder {
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getOrCreateCommodityFixedPhysicalQuantityModel();
		CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder getCommodityFixedPhysicalQuantityModel();
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setId(String id);
		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("commodityFixedPhysicalQuantityModel"), processor, CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder.class, getCommodityFixedPhysicalQuantityModel());
		}
		

		CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityPhysicalQuantity  ***********************/
	class CommodityPhysicalQuantityImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseImpl implements CommodityPhysicalQuantity {
		private final CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel;
		
		protected CommodityPhysicalQuantityImpl(CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder) {
			super(builder);
			this.commodityFixedPhysicalQuantityModel = ofNullable(builder.getCommodityFixedPhysicalQuantityModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityFixedPhysicalQuantityModel getCommodityFixedPhysicalQuantityModel() {
			return commodityFixedPhysicalQuantityModel;
		}
		
		@Override
		public CommodityPhysicalQuantity build() {
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder() {
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCommodityFixedPhysicalQuantityModel()).ifPresent(builder::setCommodityFixedPhysicalQuantityModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantity {" +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityPhysicalQuantity  ***********************/
	class CommodityPhysicalQuantityBuilderImpl extends CommodityPhysicalQuantityBase.CommodityPhysicalQuantityBaseBuilderImpl  implements CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder {
	
		protected CommodityFixedPhysicalQuantityModel.CommodityFixedPhysicalQuantityModelBuilder commodityFixedPhysicalQuantityModel;
	
		public CommodityPhysicalQuantityBuilderImpl() {
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
		@RosettaAttribute("id")
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("commodityFixedPhysicalQuantityModel")
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder setCommodityFixedPhysicalQuantityModel(CommodityFixedPhysicalQuantityModel commodityFixedPhysicalQuantityModel) {
			this.commodityFixedPhysicalQuantityModel = commodityFixedPhysicalQuantityModel==null?null:commodityFixedPhysicalQuantityModel.toBuilder();
			return this;
		}
		
		@Override
		public CommodityPhysicalQuantity build() {
			return new CommodityPhysicalQuantity.CommodityPhysicalQuantityImpl(this);
		}
		
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder prune() {
			super.prune();
			if (commodityFixedPhysicalQuantityModel!=null && !commodityFixedPhysicalQuantityModel.prune().hasData()) commodityFixedPhysicalQuantityModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCommodityFixedPhysicalQuantityModel()!=null && getCommodityFixedPhysicalQuantityModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder o = (CommodityPhysicalQuantity.CommodityPhysicalQuantityBuilder) other;
			
			merger.mergeRosetta(getCommodityFixedPhysicalQuantityModel(), o.getCommodityFixedPhysicalQuantityModel(), this::setCommodityFixedPhysicalQuantityModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityPhysicalQuantity _that = getType().cast(o);
		
			if (!Objects.equals(commodityFixedPhysicalQuantityModel, _that.getCommodityFixedPhysicalQuantityModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (commodityFixedPhysicalQuantityModel != null ? commodityFixedPhysicalQuantityModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityPhysicalQuantityBuilder {" +
				"commodityFixedPhysicalQuantityModel=" + this.commodityFixedPhysicalQuantityModel +
			'}' + " " + super.toString();
		}
	}
}

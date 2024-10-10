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
import fpml.confirmation.CommodityDeliveryPoint;
import fpml.confirmation.ElectricityDeliveryUnitFirm;
import fpml.confirmation.ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder;
import fpml.confirmation.ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl;
import fpml.confirmation.ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmImpl;
import fpml.confirmation.meta.ElectricityDeliveryUnitFirmMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery obligation options specific to a unit firm transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDeliveryUnitFirm", builder=ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl.class, version="${project.version}")
public interface ElectricityDeliveryUnitFirm extends RosettaModelObject {

	ElectricityDeliveryUnitFirmMeta metaData = new ElectricityDeliveryUnitFirmMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that the trade is for a Unit Firm product. Should always be set to &quot;true&quot;.
	 */
	Boolean getApplicable();
	CommodityDeliveryPoint getGenerationAsset();

	/*********************** Build Methods  ***********************/
	ElectricityDeliveryUnitFirm build();
	
	ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder();
	
	static ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder() {
		return new ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDeliveryUnitFirm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDeliveryUnitFirm> getType() {
		return ElectricityDeliveryUnitFirm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("generationAsset"), processor, CommodityDeliveryPoint.class, getGenerationAsset());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryUnitFirmBuilder extends ElectricityDeliveryUnitFirm, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateGenerationAsset();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getGenerationAsset();
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setApplicable(Boolean applicable);
		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setGenerationAsset(CommodityDeliveryPoint generationAsset);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("generationAsset"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getGenerationAsset());
		}
		

		ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDeliveryUnitFirm  ***********************/
	class ElectricityDeliveryUnitFirmImpl implements ElectricityDeliveryUnitFirm {
		private final Boolean applicable;
		private final CommodityDeliveryPoint generationAsset;
		
		protected ElectricityDeliveryUnitFirmImpl(ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder) {
			this.applicable = builder.getApplicable();
			this.generationAsset = ofNullable(builder.getGenerationAsset()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("generationAsset")
		public CommodityDeliveryPoint getGenerationAsset() {
			return generationAsset;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm build() {
			return this;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder() {
			ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getGenerationAsset()).ifPresent(builder::setGenerationAsset);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryUnitFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(generationAsset, _that.getGenerationAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (generationAsset != null ? generationAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryUnitFirm {" +
				"applicable=" + this.applicable + ", " +
				"generationAsset=" + this.generationAsset +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDeliveryUnitFirm  ***********************/
	class ElectricityDeliveryUnitFirmBuilderImpl implements ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder generationAsset;
	
		public ElectricityDeliveryUnitFirmBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("generationAsset")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getGenerationAsset() {
			return generationAsset;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateGenerationAsset() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (generationAsset!=null) {
				result = generationAsset;
			}
			else {
				result = generationAsset = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("generationAsset")
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder setGenerationAsset(CommodityDeliveryPoint generationAsset) {
			this.generationAsset = generationAsset==null?null:generationAsset.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDeliveryUnitFirm build() {
			return new ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmImpl(this);
		}
		
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder prune() {
			if (generationAsset!=null && !generationAsset.prune().hasData()) generationAsset = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getGenerationAsset()!=null && getGenerationAsset().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder o = (ElectricityDeliveryUnitFirm.ElectricityDeliveryUnitFirmBuilder) other;
			
			merger.mergeRosetta(getGenerationAsset(), o.getGenerationAsset(), this::setGenerationAsset);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDeliveryUnitFirm _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(generationAsset, _that.getGenerationAsset())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (generationAsset != null ? generationAsset.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryUnitFirmBuilder {" +
				"applicable=" + this.applicable + ", " +
				"generationAsset=" + this.generationAsset +
			'}';
		}
	}
}

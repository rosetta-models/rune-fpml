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
import fpml.confirmation.OilTransferDelivery;
import fpml.confirmation.OilTransferDelivery.OilTransferDeliveryBuilder;
import fpml.confirmation.OilTransferDelivery.OilTransferDeliveryBuilderImpl;
import fpml.confirmation.OilTransferDelivery.OilTransferDeliveryImpl;
import fpml.confirmation.meta.OilTransferDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery conditions specific to an oil product delivered by title transfer.
 * @version ${project.version}
 */
@RosettaDataType(value="OilTransferDelivery", builder=OilTransferDelivery.OilTransferDeliveryBuilderImpl.class, version="${project.version}")
public interface OilTransferDelivery extends RosettaModelObject {

	OilTransferDeliveryMeta metaData = new OilTransferDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates that the oil product will be delivered by title transfer. Should always be set to &quot;true&quot;.
	 */
	Boolean getApplicable();
	/**
	 * The location at which the transfer of the title to the commodity takes place.
	 */
	CommodityDeliveryPoint getDeliveryLocation();

	/*********************** Build Methods  ***********************/
	OilTransferDelivery build();
	
	OilTransferDelivery.OilTransferDeliveryBuilder toBuilder();
	
	static OilTransferDelivery.OilTransferDeliveryBuilder builder() {
		return new OilTransferDelivery.OilTransferDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OilTransferDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OilTransferDelivery> getType() {
		return OilTransferDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
		processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.class, getDeliveryLocation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OilTransferDeliveryBuilder extends OilTransferDelivery, RosettaModelObjectBuilder {
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation();
		CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation();
		OilTransferDelivery.OilTransferDeliveryBuilder setApplicable(Boolean applicable);
		OilTransferDelivery.OilTransferDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint deliveryLocation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("applicable"), Boolean.class, getApplicable(), this);
			processRosetta(path.newSubPath("deliveryLocation"), processor, CommodityDeliveryPoint.CommodityDeliveryPointBuilder.class, getDeliveryLocation());
		}
		

		OilTransferDelivery.OilTransferDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of OilTransferDelivery  ***********************/
	class OilTransferDeliveryImpl implements OilTransferDelivery {
		private final Boolean applicable;
		private final CommodityDeliveryPoint deliveryLocation;
		
		protected OilTransferDeliveryImpl(OilTransferDelivery.OilTransferDeliveryBuilder builder) {
			this.applicable = builder.getApplicable();
			this.deliveryLocation = ofNullable(builder.getDeliveryLocation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public CommodityDeliveryPoint getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public OilTransferDelivery build() {
			return this;
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder toBuilder() {
			OilTransferDelivery.OilTransferDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OilTransferDelivery.OilTransferDeliveryBuilder builder) {
			ofNullable(getApplicable()).ifPresent(builder::setApplicable);
			ofNullable(getDeliveryLocation()).ifPresent(builder::setDeliveryLocation);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilTransferDelivery _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilTransferDelivery {" +
				"applicable=" + this.applicable + ", " +
				"deliveryLocation=" + this.deliveryLocation +
			'}';
		}
	}

	/*********************** Builder Implementation of OilTransferDelivery  ***********************/
	class OilTransferDeliveryBuilderImpl implements OilTransferDelivery.OilTransferDeliveryBuilder {
	
		protected Boolean applicable;
		protected CommodityDeliveryPoint.CommodityDeliveryPointBuilder deliveryLocation;
	
		public OilTransferDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("applicable")
		public Boolean getApplicable() {
			return applicable;
		}
		
		@Override
		@RosettaAttribute("deliveryLocation")
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getDeliveryLocation() {
			return deliveryLocation;
		}
		
		@Override
		public CommodityDeliveryPoint.CommodityDeliveryPointBuilder getOrCreateDeliveryLocation() {
			CommodityDeliveryPoint.CommodityDeliveryPointBuilder result;
			if (deliveryLocation!=null) {
				result = deliveryLocation;
			}
			else {
				result = deliveryLocation = CommodityDeliveryPoint.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("applicable")
		public OilTransferDelivery.OilTransferDeliveryBuilder setApplicable(Boolean applicable) {
			this.applicable = applicable==null?null:applicable;
			return this;
		}
		@Override
		@RosettaAttribute("deliveryLocation")
		public OilTransferDelivery.OilTransferDeliveryBuilder setDeliveryLocation(CommodityDeliveryPoint deliveryLocation) {
			this.deliveryLocation = deliveryLocation==null?null:deliveryLocation.toBuilder();
			return this;
		}
		
		@Override
		public OilTransferDelivery build() {
			return new OilTransferDelivery.OilTransferDeliveryImpl(this);
		}
		
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder prune() {
			if (deliveryLocation!=null && !deliveryLocation.prune().hasData()) deliveryLocation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getApplicable()!=null) return true;
			if (getDeliveryLocation()!=null && getDeliveryLocation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OilTransferDelivery.OilTransferDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OilTransferDelivery.OilTransferDeliveryBuilder o = (OilTransferDelivery.OilTransferDeliveryBuilder) other;
			
			merger.mergeRosetta(getDeliveryLocation(), o.getDeliveryLocation(), this::setDeliveryLocation);
			
			merger.mergeBasic(getApplicable(), o.getApplicable(), this::setApplicable);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OilTransferDelivery _that = getType().cast(o);
		
			if (!Objects.equals(applicable, _that.getApplicable())) return false;
			if (!Objects.equals(deliveryLocation, _that.getDeliveryLocation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (applicable != null ? applicable.hashCode() : 0);
			_result = 31 * _result + (deliveryLocation != null ? deliveryLocation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OilTransferDeliveryBuilder {" +
				"applicable=" + this.applicable + ", " +
				"deliveryLocation=" + this.deliveryLocation +
			'}';
		}
	}
}

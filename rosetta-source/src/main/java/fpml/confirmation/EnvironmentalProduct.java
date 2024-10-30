package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.EnvironmentalProduct;
import fpml.confirmation.EnvironmentalProduct.EnvironmentalProductBuilder;
import fpml.confirmation.EnvironmentalProduct.EnvironmentalProductBuilderImpl;
import fpml.confirmation.EnvironmentalProduct.EnvironmentalProductImpl;
import fpml.confirmation.EnvironmentalProductApplicableLaw;
import fpml.confirmation.EnvironmentalProductComplaincePeriod;
import fpml.confirmation.EnvironmentalProductTypeEnum;
import fpml.confirmation.EnvironmentalTrackingSystem;
import fpml.confirmation.meta.EnvironmentalProductMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining the characteristics of the environmental allowance or credit being traded. Settlement of environmental transactions is classified as physical because settlement is accomplished through the exchange of one or more certificates (despite the fact that this exchange is almost always executed through electronic book entry transfer between the parties allowance accounts).
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="EnvironmentalProduct", builder=EnvironmentalProduct.EnvironmentalProductBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface EnvironmentalProduct extends RosettaModelObject {

	EnvironmentalProductMeta metaData = new EnvironmentalProductMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the type of environmental allowance or credit. Examples include allowances or credit issued by the European Union (E.U.) or by the State of California in the Unites States.
	 */
	EnvironmentalProductTypeEnum getProductType();
	/**
	 * Applies to E.U. Emissions Allowance Transactions. Describes Specified Compliance Period for which the Allowances are issued.
	 */
	EnvironmentalProductComplaincePeriod getCompliancePeriod();
	/**
	 * Applies to U.S. Emissions Allowance Transactions. The year(s) of the applicable Emissions Product(s) as specified in an Emissions Transaction.
	 */
	List<Integer> getVintage();
	/**
	 * Applies to U.S. Emissions Allowance Transactions. Used to specify the Applicable Emissions Law when this is not defined in Emissions Product Definitions Exhibit.
	 */
	EnvironmentalProductApplicableLaw getApplicableLaw();
	/**
	 * Applies to U.S. Emissions Allowance Transactions. Used to specify the Tracking System when this is not defined in Emissions Product Definitions Exhibit.
	 */
	EnvironmentalTrackingSystem getTrackingSystem();

	/*********************** Build Methods  ***********************/
	EnvironmentalProduct build();
	
	EnvironmentalProduct.EnvironmentalProductBuilder toBuilder();
	
	static EnvironmentalProduct.EnvironmentalProductBuilder builder() {
		return new EnvironmentalProduct.EnvironmentalProductBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EnvironmentalProduct> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends EnvironmentalProduct> getType() {
		return EnvironmentalProduct.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("productType"), EnvironmentalProductTypeEnum.class, getProductType(), this);
		processRosetta(path.newSubPath("compliancePeriod"), processor, EnvironmentalProductComplaincePeriod.class, getCompliancePeriod());
		processor.processBasic(path.newSubPath("vintage"), Integer.class, getVintage(), this);
		processRosetta(path.newSubPath("applicableLaw"), processor, EnvironmentalProductApplicableLaw.class, getApplicableLaw());
		processRosetta(path.newSubPath("trackingSystem"), processor, EnvironmentalTrackingSystem.class, getTrackingSystem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EnvironmentalProductBuilder extends EnvironmentalProduct, RosettaModelObjectBuilder {
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getOrCreateCompliancePeriod();
		EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getCompliancePeriod();
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getOrCreateApplicableLaw();
		EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getApplicableLaw();
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getOrCreateTrackingSystem();
		EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getTrackingSystem();
		EnvironmentalProduct.EnvironmentalProductBuilder setProductType(EnvironmentalProductTypeEnum productType);
		EnvironmentalProduct.EnvironmentalProductBuilder setCompliancePeriod(EnvironmentalProductComplaincePeriod compliancePeriod);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(Integer vintage0);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(Integer vintage1, int _idx);
		EnvironmentalProduct.EnvironmentalProductBuilder addVintage(List<Integer> vintage2);
		EnvironmentalProduct.EnvironmentalProductBuilder setVintage(List<Integer> vintage3);
		EnvironmentalProduct.EnvironmentalProductBuilder setApplicableLaw(EnvironmentalProductApplicableLaw applicableLaw);
		EnvironmentalProduct.EnvironmentalProductBuilder setTrackingSystem(EnvironmentalTrackingSystem trackingSystem);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("productType"), EnvironmentalProductTypeEnum.class, getProductType(), this);
			processRosetta(path.newSubPath("compliancePeriod"), processor, EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder.class, getCompliancePeriod());
			processor.processBasic(path.newSubPath("vintage"), Integer.class, getVintage(), this);
			processRosetta(path.newSubPath("applicableLaw"), processor, EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder.class, getApplicableLaw());
			processRosetta(path.newSubPath("trackingSystem"), processor, EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder.class, getTrackingSystem());
		}
		

		EnvironmentalProduct.EnvironmentalProductBuilder prune();
	}

	/*********************** Immutable Implementation of EnvironmentalProduct  ***********************/
	class EnvironmentalProductImpl implements EnvironmentalProduct {
		private final EnvironmentalProductTypeEnum productType;
		private final EnvironmentalProductComplaincePeriod compliancePeriod;
		private final List<Integer> vintage;
		private final EnvironmentalProductApplicableLaw applicableLaw;
		private final EnvironmentalTrackingSystem trackingSystem;
		
		protected EnvironmentalProductImpl(EnvironmentalProduct.EnvironmentalProductBuilder builder) {
			this.productType = builder.getProductType();
			this.compliancePeriod = ofNullable(builder.getCompliancePeriod()).map(f->f.build()).orElse(null);
			this.vintage = ofNullable(builder.getVintage()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.applicableLaw = ofNullable(builder.getApplicableLaw()).map(f->f.build()).orElse(null);
			this.trackingSystem = ofNullable(builder.getTrackingSystem()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("productType")
		public EnvironmentalProductTypeEnum getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("compliancePeriod")
		public EnvironmentalProductComplaincePeriod getCompliancePeriod() {
			return compliancePeriod;
		}
		
		@Override
		@RosettaAttribute("vintage")
		public List<Integer> getVintage() {
			return vintage;
		}
		
		@Override
		@RosettaAttribute("applicableLaw")
		public EnvironmentalProductApplicableLaw getApplicableLaw() {
			return applicableLaw;
		}
		
		@Override
		@RosettaAttribute("trackingSystem")
		public EnvironmentalTrackingSystem getTrackingSystem() {
			return trackingSystem;
		}
		
		@Override
		public EnvironmentalProduct build() {
			return this;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder toBuilder() {
			EnvironmentalProduct.EnvironmentalProductBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EnvironmentalProduct.EnvironmentalProductBuilder builder) {
			ofNullable(getProductType()).ifPresent(builder::setProductType);
			ofNullable(getCompliancePeriod()).ifPresent(builder::setCompliancePeriod);
			ofNullable(getVintage()).ifPresent(builder::setVintage);
			ofNullable(getApplicableLaw()).ifPresent(builder::setApplicableLaw);
			ofNullable(getTrackingSystem()).ifPresent(builder::setTrackingSystem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProduct _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(compliancePeriod, _that.getCompliancePeriod())) return false;
			if (!ListEquals.listEquals(vintage, _that.getVintage())) return false;
			if (!Objects.equals(applicableLaw, _that.getApplicableLaw())) return false;
			if (!Objects.equals(trackingSystem, _that.getTrackingSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productType != null ? productType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compliancePeriod != null ? compliancePeriod.hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			_result = 31 * _result + (applicableLaw != null ? applicableLaw.hashCode() : 0);
			_result = 31 * _result + (trackingSystem != null ? trackingSystem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProduct {" +
				"productType=" + this.productType + ", " +
				"compliancePeriod=" + this.compliancePeriod + ", " +
				"vintage=" + this.vintage + ", " +
				"applicableLaw=" + this.applicableLaw + ", " +
				"trackingSystem=" + this.trackingSystem +
			'}';
		}
	}

	/*********************** Builder Implementation of EnvironmentalProduct  ***********************/
	class EnvironmentalProductBuilderImpl implements EnvironmentalProduct.EnvironmentalProductBuilder {
	
		protected EnvironmentalProductTypeEnum productType;
		protected EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder compliancePeriod;
		protected List<Integer> vintage = new ArrayList<>();
		protected EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder applicableLaw;
		protected EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder trackingSystem;
	
		public EnvironmentalProductBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("productType")
		public EnvironmentalProductTypeEnum getProductType() {
			return productType;
		}
		
		@Override
		@RosettaAttribute("compliancePeriod")
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getCompliancePeriod() {
			return compliancePeriod;
		}
		
		@Override
		public EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder getOrCreateCompliancePeriod() {
			EnvironmentalProductComplaincePeriod.EnvironmentalProductComplaincePeriodBuilder result;
			if (compliancePeriod!=null) {
				result = compliancePeriod;
			}
			else {
				result = compliancePeriod = EnvironmentalProductComplaincePeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("vintage")
		public List<Integer> getVintage() {
			return vintage;
		}
		
		@Override
		@RosettaAttribute("applicableLaw")
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getApplicableLaw() {
			return applicableLaw;
		}
		
		@Override
		public EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder getOrCreateApplicableLaw() {
			EnvironmentalProductApplicableLaw.EnvironmentalProductApplicableLawBuilder result;
			if (applicableLaw!=null) {
				result = applicableLaw;
			}
			else {
				result = applicableLaw = EnvironmentalProductApplicableLaw.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trackingSystem")
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getTrackingSystem() {
			return trackingSystem;
		}
		
		@Override
		public EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder getOrCreateTrackingSystem() {
			EnvironmentalTrackingSystem.EnvironmentalTrackingSystemBuilder result;
			if (trackingSystem!=null) {
				result = trackingSystem;
			}
			else {
				result = trackingSystem = EnvironmentalTrackingSystem.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productType")
		public EnvironmentalProduct.EnvironmentalProductBuilder setProductType(EnvironmentalProductTypeEnum productType) {
			this.productType = productType==null?null:productType;
			return this;
		}
		@Override
		@RosettaAttribute("compliancePeriod")
		public EnvironmentalProduct.EnvironmentalProductBuilder setCompliancePeriod(EnvironmentalProductComplaincePeriod compliancePeriod) {
			this.compliancePeriod = compliancePeriod==null?null:compliancePeriod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("vintage")
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(Integer vintage) {
			if (vintage!=null) this.vintage.add(vintage);
			return this;
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(Integer vintage, int _idx) {
			getIndex(this.vintage, _idx, () -> vintage);
			return this;
		}
		@Override 
		public EnvironmentalProduct.EnvironmentalProductBuilder addVintage(List<Integer> vintages) {
			if (vintages != null) {
				for (Integer toAdd : vintages) {
					this.vintage.add(toAdd);
				}
			}
			return this;
		}
		
		@Override 
		public EnvironmentalProduct.EnvironmentalProductBuilder setVintage(List<Integer> vintages) {
			if (vintages == null)  {
				this.vintage = new ArrayList<>();
			}
			else {
				this.vintage = vintages.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("applicableLaw")
		public EnvironmentalProduct.EnvironmentalProductBuilder setApplicableLaw(EnvironmentalProductApplicableLaw applicableLaw) {
			this.applicableLaw = applicableLaw==null?null:applicableLaw.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("trackingSystem")
		public EnvironmentalProduct.EnvironmentalProductBuilder setTrackingSystem(EnvironmentalTrackingSystem trackingSystem) {
			this.trackingSystem = trackingSystem==null?null:trackingSystem.toBuilder();
			return this;
		}
		
		@Override
		public EnvironmentalProduct build() {
			return new EnvironmentalProduct.EnvironmentalProductImpl(this);
		}
		
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder prune() {
			if (compliancePeriod!=null && !compliancePeriod.prune().hasData()) compliancePeriod = null;
			if (applicableLaw!=null && !applicableLaw.prune().hasData()) applicableLaw = null;
			if (trackingSystem!=null && !trackingSystem.prune().hasData()) trackingSystem = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getProductType()!=null) return true;
			if (getCompliancePeriod()!=null && getCompliancePeriod().hasData()) return true;
			if (getVintage()!=null && !getVintage().isEmpty()) return true;
			if (getApplicableLaw()!=null && getApplicableLaw().hasData()) return true;
			if (getTrackingSystem()!=null && getTrackingSystem().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EnvironmentalProduct.EnvironmentalProductBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			EnvironmentalProduct.EnvironmentalProductBuilder o = (EnvironmentalProduct.EnvironmentalProductBuilder) other;
			
			merger.mergeRosetta(getCompliancePeriod(), o.getCompliancePeriod(), this::setCompliancePeriod);
			merger.mergeRosetta(getApplicableLaw(), o.getApplicableLaw(), this::setApplicableLaw);
			merger.mergeRosetta(getTrackingSystem(), o.getTrackingSystem(), this::setTrackingSystem);
			
			merger.mergeBasic(getProductType(), o.getProductType(), this::setProductType);
			merger.mergeBasic(getVintage(), o.getVintage(), (Consumer<Integer>) this::addVintage);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			EnvironmentalProduct _that = getType().cast(o);
		
			if (!Objects.equals(productType, _that.getProductType())) return false;
			if (!Objects.equals(compliancePeriod, _that.getCompliancePeriod())) return false;
			if (!ListEquals.listEquals(vintage, _that.getVintage())) return false;
			if (!Objects.equals(applicableLaw, _that.getApplicableLaw())) return false;
			if (!Objects.equals(trackingSystem, _that.getTrackingSystem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (productType != null ? productType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (compliancePeriod != null ? compliancePeriod.hashCode() : 0);
			_result = 31 * _result + (vintage != null ? vintage.hashCode() : 0);
			_result = 31 * _result + (applicableLaw != null ? applicableLaw.hashCode() : 0);
			_result = 31 * _result + (trackingSystem != null ? trackingSystem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EnvironmentalProductBuilder {" +
				"productType=" + this.productType + ", " +
				"compliancePeriod=" + this.compliancePeriod + ", " +
				"vintage=" + this.vintage + ", " +
				"applicableLaw=" + this.applicableLaw + ", " +
				"trackingSystem=" + this.trackingSystem +
			'}';
		}
	}
}

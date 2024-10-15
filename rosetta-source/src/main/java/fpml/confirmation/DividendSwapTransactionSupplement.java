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
import fpml.confirmation.DividendLeg;
import fpml.confirmation.DividendSwapTransactionSupplement;
import fpml.confirmation.DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder;
import fpml.confirmation.DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl;
import fpml.confirmation.DividendSwapTransactionSupplement.DividendSwapTransactionSupplementImpl;
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.FixedPaymentLeg;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.meta.DividendSwapTransactionSupplementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of the dividend swap transaction supplement. A Dividend Swap Transaction Supplement.
 * @version ${project.version}
 */
@RosettaDataType(value="DividendSwapTransactionSupplement", builder=DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface DividendSwapTransactionSupplement extends Product {

	DividendSwapTransactionSupplementMeta metaData = new DividendSwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Dividend leg.
	 */
	DividendLeg getDividendLeg();
	/**
	 * Fixed payment leg.
	 */
	FixedPaymentLeg getFixedLeg();
	EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel();

	/*********************** Build Methods  ***********************/
	DividendSwapTransactionSupplement build();
	
	DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder();
	
	static DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder() {
		return new DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DividendSwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends DividendSwapTransactionSupplement> getType() {
		return DividendSwapTransactionSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("dividendLeg"), processor, DividendLeg.class, getDividendLeg());
		processRosetta(path.newSubPath("fixedLeg"), processor, FixedPaymentLeg.class, getFixedLeg());
		processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.class, getEquityUnderlyerProvisionsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DividendSwapTransactionSupplementBuilder extends DividendSwapTransactionSupplement, Product.ProductBuilder {
		DividendLeg.DividendLegBuilder getOrCreateDividendLeg();
		DividendLeg.DividendLegBuilder getDividendLeg();
		FixedPaymentLeg.FixedPaymentLegBuilder getOrCreateFixedLeg();
		FixedPaymentLeg.FixedPaymentLegBuilder getFixedLeg();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel();
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductModel(ProductModel productModel);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setId(String id);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setDividendLeg(DividendLeg dividendLeg);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setFixedLeg(FixedPaymentLeg fixedLeg);
		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("dividendLeg"), processor, DividendLeg.DividendLegBuilder.class, getDividendLeg());
			processRosetta(path.newSubPath("fixedLeg"), processor, FixedPaymentLeg.FixedPaymentLegBuilder.class, getFixedLeg());
			processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder.class, getEquityUnderlyerProvisionsModel());
		}
		

		DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of DividendSwapTransactionSupplement  ***********************/
	class DividendSwapTransactionSupplementImpl extends Product.ProductImpl implements DividendSwapTransactionSupplement {
		private final DividendLeg dividendLeg;
		private final FixedPaymentLeg fixedLeg;
		private final EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel;
		
		protected DividendSwapTransactionSupplementImpl(DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder) {
			super(builder);
			this.dividendLeg = ofNullable(builder.getDividendLeg()).map(f->f.build()).orElse(null);
			this.fixedLeg = ofNullable(builder.getFixedLeg()).map(f->f.build()).orElse(null);
			this.equityUnderlyerProvisionsModel = ofNullable(builder.getEquityUnderlyerProvisionsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dividendLeg")
		public DividendLeg getDividendLeg() {
			return dividendLeg;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public FixedPaymentLeg getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public DividendSwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder() {
			DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDividendLeg()).ifPresent(builder::setDividendLeg);
			ofNullable(getFixedLeg()).ifPresent(builder::setFixedLeg);
			ofNullable(getEquityUnderlyerProvisionsModel()).ifPresent(builder::setEquityUnderlyerProvisionsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendSwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(dividendLeg, _that.getDividendLeg())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendLeg != null ? dividendLeg.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapTransactionSupplement {" +
				"dividendLeg=" + this.dividendLeg + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DividendSwapTransactionSupplement  ***********************/
	class DividendSwapTransactionSupplementBuilderImpl extends Product.ProductBuilderImpl  implements DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder {
	
		protected DividendLeg.DividendLegBuilder dividendLeg;
		protected FixedPaymentLeg.FixedPaymentLegBuilder fixedLeg;
		protected EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder equityUnderlyerProvisionsModel;
	
		public DividendSwapTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("dividendLeg")
		public DividendLeg.DividendLegBuilder getDividendLeg() {
			return dividendLeg;
		}
		
		@Override
		public DividendLeg.DividendLegBuilder getOrCreateDividendLeg() {
			DividendLeg.DividendLegBuilder result;
			if (dividendLeg!=null) {
				result = dividendLeg;
			}
			else {
				result = dividendLeg = DividendLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixedLeg")
		public FixedPaymentLeg.FixedPaymentLegBuilder getFixedLeg() {
			return fixedLeg;
		}
		
		@Override
		public FixedPaymentLeg.FixedPaymentLegBuilder getOrCreateFixedLeg() {
			FixedPaymentLeg.FixedPaymentLegBuilder result;
			if (fixedLeg!=null) {
				result = fixedLeg;
			}
			else {
				result = fixedLeg = FixedPaymentLeg.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel() {
			EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder result;
			if (equityUnderlyerProvisionsModel!=null) {
				result = equityUnderlyerProvisionsModel;
			}
			else {
				result = equityUnderlyerProvisionsModel = EquityUnderlyerProvisionsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("productModel")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("dividendLeg")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setDividendLeg(DividendLeg dividendLeg) {
			this.dividendLeg = dividendLeg==null?null:dividendLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedLeg")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setFixedLeg(FixedPaymentLeg fixedLeg) {
			this.fixedLeg = fixedLeg==null?null:fixedLeg.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel) {
			this.equityUnderlyerProvisionsModel = equityUnderlyerProvisionsModel==null?null:equityUnderlyerProvisionsModel.toBuilder();
			return this;
		}
		
		@Override
		public DividendSwapTransactionSupplement build() {
			return new DividendSwapTransactionSupplement.DividendSwapTransactionSupplementImpl(this);
		}
		
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder prune() {
			super.prune();
			if (dividendLeg!=null && !dividendLeg.prune().hasData()) dividendLeg = null;
			if (fixedLeg!=null && !fixedLeg.prune().hasData()) fixedLeg = null;
			if (equityUnderlyerProvisionsModel!=null && !equityUnderlyerProvisionsModel.prune().hasData()) equityUnderlyerProvisionsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDividendLeg()!=null && getDividendLeg().hasData()) return true;
			if (getFixedLeg()!=null && getFixedLeg().hasData()) return true;
			if (getEquityUnderlyerProvisionsModel()!=null && getEquityUnderlyerProvisionsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder o = (DividendSwapTransactionSupplement.DividendSwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getDividendLeg(), o.getDividendLeg(), this::setDividendLeg);
			merger.mergeRosetta(getFixedLeg(), o.getFixedLeg(), this::setFixedLeg);
			merger.mergeRosetta(getEquityUnderlyerProvisionsModel(), o.getEquityUnderlyerProvisionsModel(), this::setEquityUnderlyerProvisionsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DividendSwapTransactionSupplement _that = getType().cast(o);
		
			if (!Objects.equals(dividendLeg, _that.getDividendLeg())) return false;
			if (!Objects.equals(fixedLeg, _that.getFixedLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dividendLeg != null ? dividendLeg.hashCode() : 0);
			_result = 31 * _result + (fixedLeg != null ? fixedLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DividendSwapTransactionSupplementBuilder {" +
				"dividendLeg=" + this.dividendLeg + ", " +
				"fixedLeg=" + this.fixedLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}
}

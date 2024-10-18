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
import fpml.confirmation.EquityUnderlyerProvisionsModel;
import fpml.confirmation.Product;
import fpml.confirmation.Product.ProductBuilder;
import fpml.confirmation.Product.ProductBuilderImpl;
import fpml.confirmation.Product.ProductImpl;
import fpml.confirmation.ProductModel;
import fpml.confirmation.VarianceLeg;
import fpml.confirmation.VarianceSwapTransactionSupplement;
import fpml.confirmation.VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder;
import fpml.confirmation.VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilderImpl;
import fpml.confirmation.VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementImpl;
import fpml.confirmation.meta.VarianceSwapTransactionSupplementMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies the structure of a variance swap transaction supplement. A Variance Swap Transaction Supplement.
 * @version ${project.version}
 */
@RosettaDataType(value="VarianceSwapTransactionSupplement", builder=VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilderImpl.class, version="${project.version}")
public interface VarianceSwapTransactionSupplement extends Product {

	VarianceSwapTransactionSupplementMeta metaData = new VarianceSwapTransactionSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Variance Leg.
	 */
	List<? extends VarianceLeg> getVarianceLeg();
	EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel();

	/*********************** Build Methods  ***********************/
	VarianceSwapTransactionSupplement build();
	
	VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder toBuilder();
	
	static VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder builder() {
		return new VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VarianceSwapTransactionSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends VarianceSwapTransactionSupplement> getType() {
		return VarianceSwapTransactionSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("productModel"), processor, ProductModel.class, getProductModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.class, getVarianceLeg());
		processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.class, getEquityUnderlyerProvisionsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VarianceSwapTransactionSupplementBuilder extends VarianceSwapTransactionSupplement, Product.ProductBuilder {
		VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int _index);
		List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getOrCreateEquityUnderlyerProvisionsModel();
		EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder getEquityUnderlyerProvisionsModel();
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setProductModel(ProductModel productModel);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setId(String id);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(VarianceLeg varianceLeg0);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(VarianceLeg varianceLeg1, int _idx);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLeg2);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLeg3);
		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("productModel"), processor, ProductModel.ProductModelBuilder.class, getProductModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("varianceLeg"), processor, VarianceLeg.VarianceLegBuilder.class, getVarianceLeg());
			processRosetta(path.newSubPath("equityUnderlyerProvisionsModel"), processor, EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder.class, getEquityUnderlyerProvisionsModel());
		}
		

		VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of VarianceSwapTransactionSupplement  ***********************/
	class VarianceSwapTransactionSupplementImpl extends Product.ProductImpl implements VarianceSwapTransactionSupplement {
		private final List<? extends VarianceLeg> varianceLeg;
		private final EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel;
		
		protected VarianceSwapTransactionSupplementImpl(VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder builder) {
			super(builder);
			this.varianceLeg = ofNullable(builder.getVarianceLeg()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.equityUnderlyerProvisionsModel = ofNullable(builder.getEquityUnderlyerProvisionsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("varianceLeg")
		public List<? extends VarianceLeg> getVarianceLeg() {
			return varianceLeg;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public EquityUnderlyerProvisionsModel getEquityUnderlyerProvisionsModel() {
			return equityUnderlyerProvisionsModel;
		}
		
		@Override
		public VarianceSwapTransactionSupplement build() {
			return this;
		}
		
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder toBuilder() {
			VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getVarianceLeg()).ifPresent(builder::setVarianceLeg);
			ofNullable(getEquityUnderlyerProvisionsModel()).ifPresent(builder::setEquityUnderlyerProvisionsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwapTransactionSupplement {" +
				"varianceLeg=" + this.varianceLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VarianceSwapTransactionSupplement  ***********************/
	class VarianceSwapTransactionSupplementBuilderImpl extends Product.ProductBuilderImpl  implements VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder {
	
		protected List<VarianceLeg.VarianceLegBuilder> varianceLeg = new ArrayList<>();
		protected EquityUnderlyerProvisionsModel.EquityUnderlyerProvisionsModelBuilder equityUnderlyerProvisionsModel;
	
		public VarianceSwapTransactionSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("varianceLeg")
		public List<? extends VarianceLeg.VarianceLegBuilder> getVarianceLeg() {
			return varianceLeg;
		}
		
		@Override
		public VarianceLeg.VarianceLegBuilder getOrCreateVarianceLeg(int _index) {
		
			if (varianceLeg==null) {
				this.varianceLeg = new ArrayList<>();
			}
			VarianceLeg.VarianceLegBuilder result;
			return getIndex(varianceLeg, _index, () -> {
						VarianceLeg.VarianceLegBuilder newVarianceLeg = VarianceLeg.builder();
						return newVarianceLeg;
					});
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
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setProductModel(ProductModel productModel) {
			this.productModel = productModel==null?null:productModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		@RosettaAttribute("varianceLeg")
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(VarianceLeg varianceLeg) {
			if (varianceLeg!=null) this.varianceLeg.add(varianceLeg.toBuilder());
			return this;
		}
		
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(VarianceLeg varianceLeg, int _idx) {
			getIndex(this.varianceLeg, _idx, () -> varianceLeg.toBuilder());
			return this;
		}
		@Override 
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder addVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs != null) {
				for (VarianceLeg toAdd : varianceLegs) {
					this.varianceLeg.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setVarianceLeg(List<? extends VarianceLeg> varianceLegs) {
			if (varianceLegs == null)  {
				this.varianceLeg = new ArrayList<>();
			}
			else {
				this.varianceLeg = varianceLegs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("equityUnderlyerProvisionsModel")
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder setEquityUnderlyerProvisionsModel(EquityUnderlyerProvisionsModel equityUnderlyerProvisionsModel) {
			this.equityUnderlyerProvisionsModel = equityUnderlyerProvisionsModel==null?null:equityUnderlyerProvisionsModel.toBuilder();
			return this;
		}
		
		@Override
		public VarianceSwapTransactionSupplement build() {
			return new VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementImpl(this);
		}
		
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder prune() {
			super.prune();
			varianceLeg = varianceLeg.stream().filter(b->b!=null).<VarianceLeg.VarianceLegBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (equityUnderlyerProvisionsModel!=null && !equityUnderlyerProvisionsModel.prune().hasData()) equityUnderlyerProvisionsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getVarianceLeg()!=null && getVarianceLeg().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getEquityUnderlyerProvisionsModel()!=null && getEquityUnderlyerProvisionsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder o = (VarianceSwapTransactionSupplement.VarianceSwapTransactionSupplementBuilder) other;
			
			merger.mergeRosetta(getVarianceLeg(), o.getVarianceLeg(), this::getOrCreateVarianceLeg);
			merger.mergeRosetta(getEquityUnderlyerProvisionsModel(), o.getEquityUnderlyerProvisionsModel(), this::setEquityUnderlyerProvisionsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VarianceSwapTransactionSupplement _that = getType().cast(o);
		
			if (!ListEquals.listEquals(varianceLeg, _that.getVarianceLeg())) return false;
			if (!Objects.equals(equityUnderlyerProvisionsModel, _that.getEquityUnderlyerProvisionsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (varianceLeg != null ? varianceLeg.hashCode() : 0);
			_result = 31 * _result + (equityUnderlyerProvisionsModel != null ? equityUnderlyerProvisionsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VarianceSwapTransactionSupplementBuilder {" +
				"varianceLeg=" + this.varianceLeg + ", " +
				"equityUnderlyerProvisionsModel=" + this.equityUnderlyerProvisionsModel +
			'}' + " " + super.toString();
		}
	}
}

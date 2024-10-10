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
import fpml.confirmation.CommodityBasketBase;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseBuilder;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseBuilderImpl;
import fpml.confirmation.CommodityBasketBase.CommodityBasketBaseImpl;
import fpml.confirmation.CommodityBasketByPercentage;
import fpml.confirmation.CommodityBasketByPercentage.CommodityBasketByPercentageBuilder;
import fpml.confirmation.CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl;
import fpml.confirmation.CommodityBasketByPercentage.CommodityBasketByPercentageImpl;
import fpml.confirmation.CommodityBasketUnderlyingByPercentage;
import fpml.confirmation.NotionalAmount;
import fpml.confirmation.meta.CommodityBasketByPercentageMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketByPercentage", builder=CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl.class, version="${project.version}")
public interface CommodityBasketByPercentage extends CommodityBasketBase {

	CommodityBasketByPercentageMeta metaData = new CommodityBasketByPercentageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the role of the option buyer with regard to this underlyer.
	 */
	List<? extends CommodityBasketUnderlyingByPercentage> getUnderlying();
	NotionalAmount getNotionalAmount();

	/*********************** Build Methods  ***********************/
	CommodityBasketByPercentage build();
	
	CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder();
	
	static CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder() {
		return new CommodityBasketByPercentage.CommodityBasketByPercentageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketByPercentage> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketByPercentage> getType() {
		return CommodityBasketByPercentage.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByPercentage.class, getUnderlying());
		processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.class, getNotionalAmount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketByPercentageBuilder extends CommodityBasketByPercentage, CommodityBasketBase.CommodityBasketBaseBuilder {
		CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder getOrCreateUnderlying(int _index);
		List<? extends CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> getUnderlying();
		NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount();
		NotionalAmount.NotionalAmountBuilder getNotionalAmount();
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setId(String id);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying0);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying1, int _idx);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlying2);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlying3);
		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setNotionalAmount(NotionalAmount notionalAmount);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder.class, getUnderlying());
			processRosetta(path.newSubPath("notionalAmount"), processor, NotionalAmount.NotionalAmountBuilder.class, getNotionalAmount());
		}
		

		CommodityBasketByPercentage.CommodityBasketByPercentageBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketByPercentage  ***********************/
	class CommodityBasketByPercentageImpl extends CommodityBasketBase.CommodityBasketBaseImpl implements CommodityBasketByPercentage {
		private final List<? extends CommodityBasketUnderlyingByPercentage> underlying;
		private final NotionalAmount notionalAmount;
		
		protected CommodityBasketByPercentageImpl(CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder) {
			super(builder);
			this.underlying = ofNullable(builder.getUnderlying()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.notionalAmount = ofNullable(builder.getNotionalAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByPercentage> getUnderlying() {
			return underlying;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public CommodityBasketByPercentage build() {
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder() {
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketByPercentage.CommodityBasketByPercentageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
			ofNullable(getNotionalAmount()).ifPresent(builder::setNotionalAmount);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByPercentage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByPercentage {" +
				"underlying=" + this.underlying + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketByPercentage  ***********************/
	class CommodityBasketByPercentageBuilderImpl extends CommodityBasketBase.CommodityBasketBaseBuilderImpl  implements CommodityBasketByPercentage.CommodityBasketByPercentageBuilder {
	
		protected List<CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> underlying = new ArrayList<>();
		protected NotionalAmount.NotionalAmountBuilder notionalAmount;
	
		public CommodityBasketByPercentageBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder> getUnderlying() {
			return underlying;
		}
		
		public CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder getOrCreateUnderlying(int _index) {
		
			if (underlying==null) {
				this.underlying = new ArrayList<>();
			}
			CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder result;
			return getIndex(underlying, _index, () -> {
						CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder newUnderlying = CommodityBasketUnderlyingByPercentage.builder();
						return newUnderlying;
					});
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public NotionalAmount.NotionalAmountBuilder getNotionalAmount() {
			return notionalAmount;
		}
		
		@Override
		public NotionalAmount.NotionalAmountBuilder getOrCreateNotionalAmount() {
			NotionalAmount.NotionalAmountBuilder result;
			if (notionalAmount!=null) {
				result = notionalAmount;
			}
			else {
				result = notionalAmount = NotionalAmount.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying) {
			if (underlying!=null) this.underlying.add(underlying.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(CommodityBasketUnderlyingByPercentage underlying, int _idx) {
			getIndex(this.underlying, _idx, () -> underlying.toBuilder());
			return this;
		}
		@Override 
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlyings) {
			if (underlyings != null) {
				for (CommodityBasketUnderlyingByPercentage toAdd : underlyings) {
					this.underlying.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("underlying")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByPercentage> underlyings) {
			if (underlyings == null)  {
				this.underlying = new ArrayList<>();
			}
			else {
				this.underlying = underlyings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		@RosettaAttribute("notionalAmount")
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder setNotionalAmount(NotionalAmount notionalAmount) {
			this.notionalAmount = notionalAmount==null?null:notionalAmount.toBuilder();
			return this;
		}
		
		@Override
		public CommodityBasketByPercentage build() {
			return new CommodityBasketByPercentage.CommodityBasketByPercentageImpl(this);
		}
		
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder prune() {
			super.prune();
			underlying = underlying.stream().filter(b->b!=null).<CommodityBasketUnderlyingByPercentage.CommodityBasketUnderlyingByPercentageBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (notionalAmount!=null && !notionalAmount.prune().hasData()) notionalAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlying()!=null && getUnderlying().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getNotionalAmount()!=null && getNotionalAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByPercentage.CommodityBasketByPercentageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityBasketByPercentage.CommodityBasketByPercentageBuilder o = (CommodityBasketByPercentage.CommodityBasketByPercentageBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::getOrCreateUnderlying);
			merger.mergeRosetta(getNotionalAmount(), o.getNotionalAmount(), this::setNotionalAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByPercentage _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			if (!Objects.equals(notionalAmount, _that.getNotionalAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			_result = 31 * _result + (notionalAmount != null ? notionalAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByPercentageBuilder {" +
				"underlying=" + this.underlying + ", " +
				"notionalAmount=" + this.notionalAmount +
			'}' + " " + super.toString();
		}
	}
}

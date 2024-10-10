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
import fpml.confirmation.CommodityBasketByNotional;
import fpml.confirmation.CommodityBasketByNotional.CommodityBasketByNotionalBuilder;
import fpml.confirmation.CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl;
import fpml.confirmation.CommodityBasketByNotional.CommodityBasketByNotionalImpl;
import fpml.confirmation.CommodityBasketUnderlyingByNotional;
import fpml.confirmation.meta.CommodityBasketByNotionalMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CommodityBasketByNotional", builder=CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl.class, version="${project.version}")
public interface CommodityBasketByNotional extends CommodityBasketBase {

	CommodityBasketByNotionalMeta metaData = new CommodityBasketByNotionalMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the role of the option buyer with regard to this underlyer.
	 */
	List<? extends CommodityBasketUnderlyingByNotional> getUnderlying();

	/*********************** Build Methods  ***********************/
	CommodityBasketByNotional build();
	
	CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder();
	
	static CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder() {
		return new CommodityBasketByNotional.CommodityBasketByNotionalBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CommodityBasketByNotional> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CommodityBasketByNotional> getType() {
		return CommodityBasketByNotional.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByNotional.class, getUnderlying());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CommodityBasketByNotionalBuilder extends CommodityBasketByNotional, CommodityBasketBase.CommodityBasketBaseBuilder {
		CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder getOrCreateUnderlying(int _index);
		List<? extends CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> getUnderlying();
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder setId(String id);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying0);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying1, int _idx);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlying2);
		CommodityBasketByNotional.CommodityBasketByNotionalBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlying3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("underlying"), processor, CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder.class, getUnderlying());
		}
		

		CommodityBasketByNotional.CommodityBasketByNotionalBuilder prune();
	}

	/*********************** Immutable Implementation of CommodityBasketByNotional  ***********************/
	class CommodityBasketByNotionalImpl extends CommodityBasketBase.CommodityBasketBaseImpl implements CommodityBasketByNotional {
		private final List<? extends CommodityBasketUnderlyingByNotional> underlying;
		
		protected CommodityBasketByNotionalImpl(CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder) {
			super(builder);
			this.underlying = ofNullable(builder.getUnderlying()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByNotional> getUnderlying() {
			return underlying;
		}
		
		@Override
		public CommodityBasketByNotional build() {
			return this;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder() {
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CommodityBasketByNotional.CommodityBasketByNotionalBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getUnderlying()).ifPresent(builder::setUnderlying);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByNotional _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByNotional {" +
				"underlying=" + this.underlying +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of CommodityBasketByNotional  ***********************/
	class CommodityBasketByNotionalBuilderImpl extends CommodityBasketBase.CommodityBasketBaseBuilderImpl  implements CommodityBasketByNotional.CommodityBasketByNotionalBuilder {
	
		protected List<CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> underlying = new ArrayList<>();
	
		public CommodityBasketByNotionalBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlying")
		public List<? extends CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder> getUnderlying() {
			return underlying;
		}
		
		public CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder getOrCreateUnderlying(int _index) {
		
			if (underlying==null) {
				this.underlying = new ArrayList<>();
			}
			CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder result;
			return getIndex(underlying, _index, () -> {
						CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder newUnderlying = CommodityBasketUnderlyingByNotional.builder();
						return newUnderlying;
					});
		}
		
		@Override
		@RosettaAttribute("id")
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying) {
			if (underlying!=null) this.underlying.add(underlying.toBuilder());
			return this;
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(CommodityBasketUnderlyingByNotional underlying, int _idx) {
			getIndex(this.underlying, _idx, () -> underlying.toBuilder());
			return this;
		}
		@Override 
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder addUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlyings) {
			if (underlyings != null) {
				for (CommodityBasketUnderlyingByNotional toAdd : underlyings) {
					this.underlying.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("underlying")
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder setUnderlying(List<? extends CommodityBasketUnderlyingByNotional> underlyings) {
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
		public CommodityBasketByNotional build() {
			return new CommodityBasketByNotional.CommodityBasketByNotionalImpl(this);
		}
		
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder prune() {
			super.prune();
			underlying = underlying.stream().filter(b->b!=null).<CommodityBasketUnderlyingByNotional.CommodityBasketUnderlyingByNotionalBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getUnderlying()!=null && getUnderlying().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CommodityBasketByNotional.CommodityBasketByNotionalBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			CommodityBasketByNotional.CommodityBasketByNotionalBuilder o = (CommodityBasketByNotional.CommodityBasketByNotionalBuilder) other;
			
			merger.mergeRosetta(getUnderlying(), o.getUnderlying(), this::getOrCreateUnderlying);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			CommodityBasketByNotional _that = getType().cast(o);
		
			if (!ListEquals.listEquals(underlying, _that.getUnderlying())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (underlying != null ? underlying.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CommodityBasketByNotionalBuilder {" +
				"underlying=" + this.underlying +
			'}' + " " + super.toString();
		}
	}
}

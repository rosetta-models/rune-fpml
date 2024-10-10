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
import fpml.confirmation.CollateralValueAllocation;
import fpml.confirmation.CollateralValueAllocation.CollateralValueAllocationBuilder;
import fpml.confirmation.CollateralValueAllocation.CollateralValueAllocationBuilderImpl;
import fpml.confirmation.CollateralValueAllocation.CollateralValueAllocationImpl;
import fpml.confirmation.CollateralValueAllocationEnum;
import fpml.confirmation.Money;
import fpml.confirmation.meta.CollateralValueAllocationMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CollateralValueAllocation", builder=CollateralValueAllocation.CollateralValueAllocationBuilderImpl.class, version="${project.version}")
public interface CollateralValueAllocation extends RosettaModelObject {

	CollateralValueAllocationMeta metaData = new CollateralValueAllocationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of allocation e.g. Full or ExcessOverMargin
	 */
	CollateralValueAllocationEnum getType_();
	List<? extends Money> getValue();

	/*********************** Build Methods  ***********************/
	CollateralValueAllocation build();
	
	CollateralValueAllocation.CollateralValueAllocationBuilder toBuilder();
	
	static CollateralValueAllocation.CollateralValueAllocationBuilder builder() {
		return new CollateralValueAllocation.CollateralValueAllocationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CollateralValueAllocation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CollateralValueAllocation> getType() {
		return CollateralValueAllocation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("type"), CollateralValueAllocationEnum.class, getType_(), this);
		processRosetta(path.newSubPath("value"), processor, Money.class, getValue());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CollateralValueAllocationBuilder extends CollateralValueAllocation, RosettaModelObjectBuilder {
		Money.MoneyBuilder getOrCreateValue(int _index);
		List<? extends Money.MoneyBuilder> getValue();
		CollateralValueAllocation.CollateralValueAllocationBuilder setType(CollateralValueAllocationEnum type);
		CollateralValueAllocation.CollateralValueAllocationBuilder addValue(Money value0);
		CollateralValueAllocation.CollateralValueAllocationBuilder addValue(Money value1, int _idx);
		CollateralValueAllocation.CollateralValueAllocationBuilder addValue(List<? extends Money> value2);
		CollateralValueAllocation.CollateralValueAllocationBuilder setValue(List<? extends Money> value3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("type"), CollateralValueAllocationEnum.class, getType_(), this);
			processRosetta(path.newSubPath("value"), processor, Money.MoneyBuilder.class, getValue());
		}
		

		CollateralValueAllocation.CollateralValueAllocationBuilder prune();
	}

	/*********************** Immutable Implementation of CollateralValueAllocation  ***********************/
	class CollateralValueAllocationImpl implements CollateralValueAllocation {
		private final CollateralValueAllocationEnum type;
		private final List<? extends Money> value;
		
		protected CollateralValueAllocationImpl(CollateralValueAllocation.CollateralValueAllocationBuilder builder) {
			this.type = builder.getType_();
			this.value = ofNullable(builder.getValue()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("type")
		public CollateralValueAllocationEnum getType_() {
			return type;
		}
		
		@Override
		@RosettaAttribute("value")
		public List<? extends Money> getValue() {
			return value;
		}
		
		@Override
		public CollateralValueAllocation build() {
			return this;
		}
		
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder toBuilder() {
			CollateralValueAllocation.CollateralValueAllocationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CollateralValueAllocation.CollateralValueAllocationBuilder builder) {
			ofNullable(getType_()).ifPresent(builder::setType);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValueAllocation _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!ListEquals.listEquals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValueAllocation {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}

	/*********************** Builder Implementation of CollateralValueAllocation  ***********************/
	class CollateralValueAllocationBuilderImpl implements CollateralValueAllocation.CollateralValueAllocationBuilder {
	
		protected CollateralValueAllocationEnum type;
		protected List<Money.MoneyBuilder> value = new ArrayList<>();
	
		public CollateralValueAllocationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public CollateralValueAllocationEnum getType_() {
			return type;
		}
		
		@Override
		@RosettaAttribute("value")
		public List<? extends Money.MoneyBuilder> getValue() {
			return value;
		}
		
		public Money.MoneyBuilder getOrCreateValue(int _index) {
		
			if (value==null) {
				this.value = new ArrayList<>();
			}
			Money.MoneyBuilder result;
			return getIndex(value, _index, () -> {
						Money.MoneyBuilder newValue = Money.builder();
						return newValue;
					});
		}
		
		@Override
		@RosettaAttribute("type")
		public CollateralValueAllocation.CollateralValueAllocationBuilder setType(CollateralValueAllocationEnum type) {
			this.type = type==null?null:type;
			return this;
		}
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder addValue(Money value) {
			if (value!=null) this.value.add(value.toBuilder());
			return this;
		}
		
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder addValue(Money value, int _idx) {
			getIndex(this.value, _idx, () -> value.toBuilder());
			return this;
		}
		@Override 
		public CollateralValueAllocation.CollateralValueAllocationBuilder addValue(List<? extends Money> values) {
			if (values != null) {
				for (Money toAdd : values) {
					this.value.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("value")
		public CollateralValueAllocation.CollateralValueAllocationBuilder setValue(List<? extends Money> values) {
			if (values == null)  {
				this.value = new ArrayList<>();
			}
			else {
				this.value = values.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public CollateralValueAllocation build() {
			return new CollateralValueAllocation.CollateralValueAllocationImpl(this);
		}
		
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder prune() {
			value = value.stream().filter(b->b!=null).<Money.MoneyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType_()!=null) return true;
			if (getValue()!=null && getValue().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CollateralValueAllocation.CollateralValueAllocationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CollateralValueAllocation.CollateralValueAllocationBuilder o = (CollateralValueAllocation.CollateralValueAllocationBuilder) other;
			
			merger.mergeRosetta(getValue(), o.getValue(), this::getOrCreateValue);
			
			merger.mergeBasic(getType_(), o.getType_(), this::setType);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CollateralValueAllocation _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!ListEquals.listEquals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralValueAllocationBuilder {" +
				"type=" + this.type + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

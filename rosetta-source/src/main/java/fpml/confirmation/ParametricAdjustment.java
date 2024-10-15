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
import fpml.confirmation.ParametricAdjustment;
import fpml.confirmation.ParametricAdjustment.ParametricAdjustmentBuilder;
import fpml.confirmation.ParametricAdjustment.ParametricAdjustmentBuilderImpl;
import fpml.confirmation.ParametricAdjustment.ParametricAdjustmentImpl;
import fpml.confirmation.ParametricAdjustmentPoint;
import fpml.confirmation.PriceQuoteUnits;
import fpml.confirmation.meta.ParametricAdjustmentMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * An adjustment used to accommodate a parameter of the input trade, e.g. the strike.
 * @version ${project.version}
 */
@RosettaDataType(value="ParametricAdjustment", builder=ParametricAdjustment.ParametricAdjustmentBuilderImpl.class, version="${project.version}")
public interface ParametricAdjustment extends RosettaModelObject {

	ParametricAdjustmentMeta metaData = new ParametricAdjustmentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The name of the adjustment parameter (e.g. &quot;Volatility Skew&quot;).
	 */
	String getName();
	/**
	 * The units of the input parameter, e.g. Yield.
	 */
	PriceQuoteUnits getInputUnits();
	/**
	 * The values of the adjustment parameter.
	 */
	List<? extends ParametricAdjustmentPoint> getDatapoint();

	/*********************** Build Methods  ***********************/
	ParametricAdjustment build();
	
	ParametricAdjustment.ParametricAdjustmentBuilder toBuilder();
	
	static ParametricAdjustment.ParametricAdjustmentBuilder builder() {
		return new ParametricAdjustment.ParametricAdjustmentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ParametricAdjustment> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ParametricAdjustment> getType() {
		return ParametricAdjustment.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("inputUnits"), processor, PriceQuoteUnits.class, getInputUnits());
		processRosetta(path.newSubPath("datapoint"), processor, ParametricAdjustmentPoint.class, getDatapoint());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ParametricAdjustmentBuilder extends ParametricAdjustment, RosettaModelObjectBuilder {
		PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateInputUnits();
		PriceQuoteUnits.PriceQuoteUnitsBuilder getInputUnits();
		ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder getOrCreateDatapoint(int _index);
		List<? extends ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder> getDatapoint();
		ParametricAdjustment.ParametricAdjustmentBuilder setName(String name);
		ParametricAdjustment.ParametricAdjustmentBuilder setInputUnits(PriceQuoteUnits inputUnits);
		ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(ParametricAdjustmentPoint datapoint0);
		ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(ParametricAdjustmentPoint datapoint1, int _idx);
		ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(List<? extends ParametricAdjustmentPoint> datapoint2);
		ParametricAdjustment.ParametricAdjustmentBuilder setDatapoint(List<? extends ParametricAdjustmentPoint> datapoint3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("inputUnits"), processor, PriceQuoteUnits.PriceQuoteUnitsBuilder.class, getInputUnits());
			processRosetta(path.newSubPath("datapoint"), processor, ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder.class, getDatapoint());
		}
		

		ParametricAdjustment.ParametricAdjustmentBuilder prune();
	}

	/*********************** Immutable Implementation of ParametricAdjustment  ***********************/
	class ParametricAdjustmentImpl implements ParametricAdjustment {
		private final String name;
		private final PriceQuoteUnits inputUnits;
		private final List<? extends ParametricAdjustmentPoint> datapoint;
		
		protected ParametricAdjustmentImpl(ParametricAdjustment.ParametricAdjustmentBuilder builder) {
			this.name = builder.getName();
			this.inputUnits = ofNullable(builder.getInputUnits()).map(f->f.build()).orElse(null);
			this.datapoint = ofNullable(builder.getDatapoint()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("inputUnits")
		public PriceQuoteUnits getInputUnits() {
			return inputUnits;
		}
		
		@Override
		@RosettaAttribute("datapoint")
		public List<? extends ParametricAdjustmentPoint> getDatapoint() {
			return datapoint;
		}
		
		@Override
		public ParametricAdjustment build() {
			return this;
		}
		
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder toBuilder() {
			ParametricAdjustment.ParametricAdjustmentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ParametricAdjustment.ParametricAdjustmentBuilder builder) {
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getInputUnits()).ifPresent(builder::setInputUnits);
			ofNullable(getDatapoint()).ifPresent(builder::setDatapoint);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(inputUnits, _that.getInputUnits())) return false;
			if (!ListEquals.listEquals(datapoint, _that.getDatapoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (inputUnits != null ? inputUnits.hashCode() : 0);
			_result = 31 * _result + (datapoint != null ? datapoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricAdjustment {" +
				"name=" + this.name + ", " +
				"inputUnits=" + this.inputUnits + ", " +
				"datapoint=" + this.datapoint +
			'}';
		}
	}

	/*********************** Builder Implementation of ParametricAdjustment  ***********************/
	class ParametricAdjustmentBuilderImpl implements ParametricAdjustment.ParametricAdjustmentBuilder {
	
		protected String name;
		protected PriceQuoteUnits.PriceQuoteUnitsBuilder inputUnits;
		protected List<ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder> datapoint = new ArrayList<>();
	
		public ParametricAdjustmentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("inputUnits")
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getInputUnits() {
			return inputUnits;
		}
		
		@Override
		public PriceQuoteUnits.PriceQuoteUnitsBuilder getOrCreateInputUnits() {
			PriceQuoteUnits.PriceQuoteUnitsBuilder result;
			if (inputUnits!=null) {
				result = inputUnits;
			}
			else {
				result = inputUnits = PriceQuoteUnits.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("datapoint")
		public List<? extends ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder> getDatapoint() {
			return datapoint;
		}
		
		public ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder getOrCreateDatapoint(int _index) {
		
			if (datapoint==null) {
				this.datapoint = new ArrayList<>();
			}
			ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder result;
			return getIndex(datapoint, _index, () -> {
						ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder newDatapoint = ParametricAdjustmentPoint.builder();
						return newDatapoint;
					});
		}
		
		@Override
		@RosettaAttribute("name")
		public ParametricAdjustment.ParametricAdjustmentBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		@Override
		@RosettaAttribute("inputUnits")
		public ParametricAdjustment.ParametricAdjustmentBuilder setInputUnits(PriceQuoteUnits inputUnits) {
			this.inputUnits = inputUnits==null?null:inputUnits.toBuilder();
			return this;
		}
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(ParametricAdjustmentPoint datapoint) {
			if (datapoint!=null) this.datapoint.add(datapoint.toBuilder());
			return this;
		}
		
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(ParametricAdjustmentPoint datapoint, int _idx) {
			getIndex(this.datapoint, _idx, () -> datapoint.toBuilder());
			return this;
		}
		@Override 
		public ParametricAdjustment.ParametricAdjustmentBuilder addDatapoint(List<? extends ParametricAdjustmentPoint> datapoints) {
			if (datapoints != null) {
				for (ParametricAdjustmentPoint toAdd : datapoints) {
					this.datapoint.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("datapoint")
		public ParametricAdjustment.ParametricAdjustmentBuilder setDatapoint(List<? extends ParametricAdjustmentPoint> datapoints) {
			if (datapoints == null)  {
				this.datapoint = new ArrayList<>();
			}
			else {
				this.datapoint = datapoints.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public ParametricAdjustment build() {
			return new ParametricAdjustment.ParametricAdjustmentImpl(this);
		}
		
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder prune() {
			if (inputUnits!=null && !inputUnits.prune().hasData()) inputUnits = null;
			datapoint = datapoint.stream().filter(b->b!=null).<ParametricAdjustmentPoint.ParametricAdjustmentPointBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getName()!=null) return true;
			if (getInputUnits()!=null && getInputUnits().hasData()) return true;
			if (getDatapoint()!=null && getDatapoint().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ParametricAdjustment.ParametricAdjustmentBuilder o = (ParametricAdjustment.ParametricAdjustmentBuilder) other;
			
			merger.mergeRosetta(getInputUnits(), o.getInputUnits(), this::setInputUnits);
			merger.mergeRosetta(getDatapoint(), o.getDatapoint(), this::getOrCreateDatapoint);
			
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ParametricAdjustment _that = getType().cast(o);
		
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(inputUnits, _that.getInputUnits())) return false;
			if (!ListEquals.listEquals(datapoint, _that.getDatapoint())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (inputUnits != null ? inputUnits.hashCode() : 0);
			_result = 31 * _result + (datapoint != null ? datapoint.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ParametricAdjustmentBuilder {" +
				"name=" + this.name + ", " +
				"inputUnits=" + this.inputUnits + ", " +
				"datapoint=" + this.datapoint +
			'}';
		}
	}
}

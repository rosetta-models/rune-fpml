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
import fpml.confirmation.ElectricityDelivery;
import fpml.confirmation.ElectricityDelivery.ElectricityDeliveryBuilder;
import fpml.confirmation.ElectricityDelivery.ElectricityDeliveryBuilderImpl;
import fpml.confirmation.ElectricityDelivery.ElectricityDeliveryImpl;
import fpml.confirmation.ElectricityDeliverySequence0;
import fpml.confirmation.ElectricityDeliverySequence1;
import fpml.confirmation.meta.ElectricityDeliveryMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The physical delivery conditions for electricity.
 * @version ${project.version}
 */
@RosettaDataType(value="ElectricityDelivery", builder=ElectricityDelivery.ElectricityDeliveryBuilderImpl.class, version="${project.version}")
public interface ElectricityDelivery extends RosettaModelObject {

	ElectricityDeliveryMeta metaData = new ElectricityDeliveryMeta();

	/*********************** Getter Methods  ***********************/
	ElectricityDeliverySequence0 getElectricityDeliverySequence0();
	ElectricityDeliverySequence1 getElectricityDeliverySequence1();

	/*********************** Build Methods  ***********************/
	ElectricityDelivery build();
	
	ElectricityDelivery.ElectricityDeliveryBuilder toBuilder();
	
	static ElectricityDelivery.ElectricityDeliveryBuilder builder() {
		return new ElectricityDelivery.ElectricityDeliveryBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ElectricityDelivery> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ElectricityDelivery> getType() {
		return ElectricityDelivery.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("electricityDeliverySequence0"), processor, ElectricityDeliverySequence0.class, getElectricityDeliverySequence0());
		processRosetta(path.newSubPath("electricityDeliverySequence1"), processor, ElectricityDeliverySequence1.class, getElectricityDeliverySequence1());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ElectricityDeliveryBuilder extends ElectricityDelivery, RosettaModelObjectBuilder {
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder getOrCreateElectricityDeliverySequence0();
		ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder getElectricityDeliverySequence0();
		ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder getOrCreateElectricityDeliverySequence1();
		ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder getElectricityDeliverySequence1();
		ElectricityDelivery.ElectricityDeliveryBuilder setElectricityDeliverySequence0(ElectricityDeliverySequence0 electricityDeliverySequence0);
		ElectricityDelivery.ElectricityDeliveryBuilder setElectricityDeliverySequence1(ElectricityDeliverySequence1 electricityDeliverySequence1);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("electricityDeliverySequence0"), processor, ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder.class, getElectricityDeliverySequence0());
			processRosetta(path.newSubPath("electricityDeliverySequence1"), processor, ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder.class, getElectricityDeliverySequence1());
		}
		

		ElectricityDelivery.ElectricityDeliveryBuilder prune();
	}

	/*********************** Immutable Implementation of ElectricityDelivery  ***********************/
	class ElectricityDeliveryImpl implements ElectricityDelivery {
		private final ElectricityDeliverySequence0 electricityDeliverySequence0;
		private final ElectricityDeliverySequence1 electricityDeliverySequence1;
		
		protected ElectricityDeliveryImpl(ElectricityDelivery.ElectricityDeliveryBuilder builder) {
			this.electricityDeliverySequence0 = ofNullable(builder.getElectricityDeliverySequence0()).map(f->f.build()).orElse(null);
			this.electricityDeliverySequence1 = ofNullable(builder.getElectricityDeliverySequence1()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("electricityDeliverySequence0")
		public ElectricityDeliverySequence0 getElectricityDeliverySequence0() {
			return electricityDeliverySequence0;
		}
		
		@Override
		@RosettaAttribute("electricityDeliverySequence1")
		public ElectricityDeliverySequence1 getElectricityDeliverySequence1() {
			return electricityDeliverySequence1;
		}
		
		@Override
		public ElectricityDelivery build() {
			return this;
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder toBuilder() {
			ElectricityDelivery.ElectricityDeliveryBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ElectricityDelivery.ElectricityDeliveryBuilder builder) {
			ofNullable(getElectricityDeliverySequence0()).ifPresent(builder::setElectricityDeliverySequence0);
			ofNullable(getElectricityDeliverySequence1()).ifPresent(builder::setElectricityDeliverySequence1);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDelivery _that = getType().cast(o);
		
			if (!Objects.equals(electricityDeliverySequence0, _that.getElectricityDeliverySequence0())) return false;
			if (!Objects.equals(electricityDeliverySequence1, _that.getElectricityDeliverySequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (electricityDeliverySequence0 != null ? electricityDeliverySequence0.hashCode() : 0);
			_result = 31 * _result + (electricityDeliverySequence1 != null ? electricityDeliverySequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDelivery {" +
				"electricityDeliverySequence0=" + this.electricityDeliverySequence0 + ", " +
				"electricityDeliverySequence1=" + this.electricityDeliverySequence1 +
			'}';
		}
	}

	/*********************** Builder Implementation of ElectricityDelivery  ***********************/
	class ElectricityDeliveryBuilderImpl implements ElectricityDelivery.ElectricityDeliveryBuilder {
	
		protected ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder electricityDeliverySequence0;
		protected ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder electricityDeliverySequence1;
	
		public ElectricityDeliveryBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("electricityDeliverySequence0")
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder getElectricityDeliverySequence0() {
			return electricityDeliverySequence0;
		}
		
		@Override
		public ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder getOrCreateElectricityDeliverySequence0() {
			ElectricityDeliverySequence0.ElectricityDeliverySequence0Builder result;
			if (electricityDeliverySequence0!=null) {
				result = electricityDeliverySequence0;
			}
			else {
				result = electricityDeliverySequence0 = ElectricityDeliverySequence0.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("electricityDeliverySequence1")
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder getElectricityDeliverySequence1() {
			return electricityDeliverySequence1;
		}
		
		@Override
		public ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder getOrCreateElectricityDeliverySequence1() {
			ElectricityDeliverySequence1.ElectricityDeliverySequence1Builder result;
			if (electricityDeliverySequence1!=null) {
				result = electricityDeliverySequence1;
			}
			else {
				result = electricityDeliverySequence1 = ElectricityDeliverySequence1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("electricityDeliverySequence0")
		public ElectricityDelivery.ElectricityDeliveryBuilder setElectricityDeliverySequence0(ElectricityDeliverySequence0 electricityDeliverySequence0) {
			this.electricityDeliverySequence0 = electricityDeliverySequence0==null?null:electricityDeliverySequence0.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("electricityDeliverySequence1")
		public ElectricityDelivery.ElectricityDeliveryBuilder setElectricityDeliverySequence1(ElectricityDeliverySequence1 electricityDeliverySequence1) {
			this.electricityDeliverySequence1 = electricityDeliverySequence1==null?null:electricityDeliverySequence1.toBuilder();
			return this;
		}
		
		@Override
		public ElectricityDelivery build() {
			return new ElectricityDelivery.ElectricityDeliveryImpl(this);
		}
		
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder prune() {
			if (electricityDeliverySequence0!=null && !electricityDeliverySequence0.prune().hasData()) electricityDeliverySequence0 = null;
			if (electricityDeliverySequence1!=null && !electricityDeliverySequence1.prune().hasData()) electricityDeliverySequence1 = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getElectricityDeliverySequence0()!=null && getElectricityDeliverySequence0().hasData()) return true;
			if (getElectricityDeliverySequence1()!=null && getElectricityDeliverySequence1().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ElectricityDelivery.ElectricityDeliveryBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ElectricityDelivery.ElectricityDeliveryBuilder o = (ElectricityDelivery.ElectricityDeliveryBuilder) other;
			
			merger.mergeRosetta(getElectricityDeliverySequence0(), o.getElectricityDeliverySequence0(), this::setElectricityDeliverySequence0);
			merger.mergeRosetta(getElectricityDeliverySequence1(), o.getElectricityDeliverySequence1(), this::setElectricityDeliverySequence1);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ElectricityDelivery _that = getType().cast(o);
		
			if (!Objects.equals(electricityDeliverySequence0, _that.getElectricityDeliverySequence0())) return false;
			if (!Objects.equals(electricityDeliverySequence1, _that.getElectricityDeliverySequence1())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (electricityDeliverySequence0 != null ? electricityDeliverySequence0.hashCode() : 0);
			_result = 31 * _result + (electricityDeliverySequence1 != null ? electricityDeliverySequence1.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ElectricityDeliveryBuilder {" +
				"electricityDeliverySequence0=" + this.electricityDeliverySequence0 + ", " +
				"electricityDeliverySequence1=" + this.electricityDeliverySequence1 +
			'}';
		}
	}
}

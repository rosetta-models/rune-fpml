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
import fpml.confirmation.RoutingId;
import fpml.confirmation.RoutingId.RoutingIdBuilder;
import fpml.confirmation.RoutingId.RoutingIdBuilderImpl;
import fpml.confirmation.RoutingId.RoutingIdImpl;
import fpml.confirmation.meta.RoutingIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="RoutingId", builder=RoutingId.RoutingIdBuilderImpl.class, version="${project.version}")
public interface RoutingId extends RosettaModelObject {

	RoutingIdMeta metaData = new RoutingIdMeta();

	/*********************** Getter Methods  ***********************/
	String getValue();
	String getRoutingIdCodeScheme();

	/*********************** Build Methods  ***********************/
	RoutingId build();
	
	RoutingId.RoutingIdBuilder toBuilder();
	
	static RoutingId.RoutingIdBuilder builder() {
		return new RoutingId.RoutingIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingId> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingId> getType() {
		return RoutingId.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("routingIdCodeScheme"), String.class, getRoutingIdCodeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingIdBuilder extends RoutingId, RosettaModelObjectBuilder {
		RoutingId.RoutingIdBuilder setValue(String value);
		RoutingId.RoutingIdBuilder setRoutingIdCodeScheme(String routingIdCodeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("routingIdCodeScheme"), String.class, getRoutingIdCodeScheme(), this);
		}
		

		RoutingId.RoutingIdBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingId  ***********************/
	class RoutingIdImpl implements RoutingId {
		private final String value;
		private final String routingIdCodeScheme;
		
		protected RoutingIdImpl(RoutingId.RoutingIdBuilder builder) {
			this.value = builder.getValue();
			this.routingIdCodeScheme = builder.getRoutingIdCodeScheme();
		}
		
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("routingIdCodeScheme")
		public String getRoutingIdCodeScheme() {
			return routingIdCodeScheme;
		}
		
		@Override
		public RoutingId build() {
			return this;
		}
		
		@Override
		public RoutingId.RoutingIdBuilder toBuilder() {
			RoutingId.RoutingIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingId.RoutingIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getRoutingIdCodeScheme()).ifPresent(builder::setRoutingIdCodeScheme);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(routingIdCodeScheme, _that.getRoutingIdCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (routingIdCodeScheme != null ? routingIdCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingId {" +
				"value=" + this.value + ", " +
				"routingIdCodeScheme=" + this.routingIdCodeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingId  ***********************/
	class RoutingIdBuilderImpl implements RoutingId.RoutingIdBuilder {
	
		protected String value;
		protected String routingIdCodeScheme;
	
		public RoutingIdBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("routingIdCodeScheme")
		public String getRoutingIdCodeScheme() {
			return routingIdCodeScheme;
		}
		
		@Override
		@RosettaAttribute("value")
		public RoutingId.RoutingIdBuilder setValue(String value) {
			this.value = value==null?null:value;
			return this;
		}
		@Override
		@RosettaAttribute("routingIdCodeScheme")
		public RoutingId.RoutingIdBuilder setRoutingIdCodeScheme(String routingIdCodeScheme) {
			this.routingIdCodeScheme = routingIdCodeScheme==null?null:routingIdCodeScheme;
			return this;
		}
		
		@Override
		public RoutingId build() {
			return new RoutingId.RoutingIdImpl(this);
		}
		
		@Override
		public RoutingId.RoutingIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingId.RoutingIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getRoutingIdCodeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingId.RoutingIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingId.RoutingIdBuilder o = (RoutingId.RoutingIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getRoutingIdCodeScheme(), o.getRoutingIdCodeScheme(), this::setRoutingIdCodeScheme);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(routingIdCodeScheme, _that.getRoutingIdCodeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (routingIdCodeScheme != null ? routingIdCodeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingIdBuilder {" +
				"value=" + this.value + ", " +
				"routingIdCodeScheme=" + this.routingIdCodeScheme +
			'}';
		}
	}
}

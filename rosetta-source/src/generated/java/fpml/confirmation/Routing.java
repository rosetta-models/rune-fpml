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
import fpml.confirmation.Routing;
import fpml.confirmation.Routing.RoutingBuilder;
import fpml.confirmation.Routing.RoutingBuilderImpl;
import fpml.confirmation.Routing.RoutingImpl;
import fpml.confirmation.RoutingIdentificationModel;
import fpml.confirmation.meta.RoutingMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that provides three alternative ways of identifying a party involved in the routing of a payment. The identification may use payment system identifiers only; actual name, address and other reference information; or a combination of both.
 * @version ${project.version}
 */
@RosettaDataType(value="Routing", builder=Routing.RoutingBuilderImpl.class, version="${project.version}")
public interface Routing extends RosettaModelObject {

	RoutingMeta metaData = new RoutingMeta();

	/*********************** Getter Methods  ***********************/
	RoutingIdentificationModel getRoutingIdentificationModel();

	/*********************** Build Methods  ***********************/
	Routing build();
	
	Routing.RoutingBuilder toBuilder();
	
	static Routing.RoutingBuilder builder() {
		return new Routing.RoutingBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Routing> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends Routing> getType() {
		return Routing.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.class, getRoutingIdentificationModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingBuilder extends Routing, RosettaModelObjectBuilder {
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel();
		RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel();
		Routing.RoutingBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingIdentificationModel"), processor, RoutingIdentificationModel.RoutingIdentificationModelBuilder.class, getRoutingIdentificationModel());
		}
		

		Routing.RoutingBuilder prune();
	}

	/*********************** Immutable Implementation of Routing  ***********************/
	class RoutingImpl implements Routing {
		private final RoutingIdentificationModel routingIdentificationModel;
		
		protected RoutingImpl(Routing.RoutingBuilder builder) {
			this.routingIdentificationModel = ofNullable(builder.getRoutingIdentificationModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		public Routing build() {
			return this;
		}
		
		@Override
		public Routing.RoutingBuilder toBuilder() {
			Routing.RoutingBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Routing.RoutingBuilder builder) {
			ofNullable(getRoutingIdentificationModel()).ifPresent(builder::setRoutingIdentificationModel);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Routing _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Routing {" +
				"routingIdentificationModel=" + this.routingIdentificationModel +
			'}';
		}
	}

	/*********************** Builder Implementation of Routing  ***********************/
	class RoutingBuilderImpl implements Routing.RoutingBuilder {
	
		protected RoutingIdentificationModel.RoutingIdentificationModelBuilder routingIdentificationModel;
	
		public RoutingBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getRoutingIdentificationModel() {
			return routingIdentificationModel;
		}
		
		@Override
		public RoutingIdentificationModel.RoutingIdentificationModelBuilder getOrCreateRoutingIdentificationModel() {
			RoutingIdentificationModel.RoutingIdentificationModelBuilder result;
			if (routingIdentificationModel!=null) {
				result = routingIdentificationModel;
			}
			else {
				result = routingIdentificationModel = RoutingIdentificationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingIdentificationModel")
		public Routing.RoutingBuilder setRoutingIdentificationModel(RoutingIdentificationModel routingIdentificationModel) {
			this.routingIdentificationModel = routingIdentificationModel==null?null:routingIdentificationModel.toBuilder();
			return this;
		}
		
		@Override
		public Routing build() {
			return new Routing.RoutingImpl(this);
		}
		
		@Override
		public Routing.RoutingBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Routing.RoutingBuilder prune() {
			if (routingIdentificationModel!=null && !routingIdentificationModel.prune().hasData()) routingIdentificationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingIdentificationModel()!=null && getRoutingIdentificationModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Routing.RoutingBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Routing.RoutingBuilder o = (Routing.RoutingBuilder) other;
			
			merger.mergeRosetta(getRoutingIdentificationModel(), o.getRoutingIdentificationModel(), this::setRoutingIdentificationModel);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Routing _that = getType().cast(o);
		
			if (!Objects.equals(routingIdentificationModel, _that.getRoutingIdentificationModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingIdentificationModel != null ? routingIdentificationModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingBuilder {" +
				"routingIdentificationModel=" + this.routingIdentificationModel +
			'}';
		}
	}
}

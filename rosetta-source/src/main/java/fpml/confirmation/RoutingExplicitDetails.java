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
import fpml.confirmation.RoutingExplicitDetails;
import fpml.confirmation.RoutingExplicitDetails.RoutingExplicitDetailsBuilder;
import fpml.confirmation.RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl;
import fpml.confirmation.RoutingExplicitDetails.RoutingExplicitDetailsImpl;
import fpml.confirmation.RoutingExplicitDetailsModel;
import fpml.confirmation.meta.RoutingExplicitDetailsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type that models name, address and supplementary textual information for the purposes of identifying a party involved in the routing of a payment.
 * @version ${project.version}
 */
@RosettaDataType(value="RoutingExplicitDetails", builder=RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl.class, version="${project.version}")
public interface RoutingExplicitDetails extends RosettaModelObject {

	RoutingExplicitDetailsMeta metaData = new RoutingExplicitDetailsMeta();

	/*********************** Getter Methods  ***********************/
	RoutingExplicitDetailsModel getRoutingExplicitDetailsModel();

	/*********************** Build Methods  ***********************/
	RoutingExplicitDetails build();
	
	RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder();
	
	static RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder() {
		return new RoutingExplicitDetails.RoutingExplicitDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RoutingExplicitDetails> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RoutingExplicitDetails> getType() {
		return RoutingExplicitDetails.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("routingExplicitDetailsModel"), processor, RoutingExplicitDetailsModel.class, getRoutingExplicitDetailsModel());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RoutingExplicitDetailsBuilder extends RoutingExplicitDetails, RosettaModelObjectBuilder {
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getOrCreateRoutingExplicitDetailsModel();
		RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getRoutingExplicitDetailsModel();
		RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingExplicitDetailsModel(RoutingExplicitDetailsModel routingExplicitDetailsModel);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("routingExplicitDetailsModel"), processor, RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder.class, getRoutingExplicitDetailsModel());
		}
		

		RoutingExplicitDetails.RoutingExplicitDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RoutingExplicitDetails  ***********************/
	class RoutingExplicitDetailsImpl implements RoutingExplicitDetails {
		private final RoutingExplicitDetailsModel routingExplicitDetailsModel;
		
		protected RoutingExplicitDetailsImpl(RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder) {
			this.routingExplicitDetailsModel = ofNullable(builder.getRoutingExplicitDetailsModel()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingExplicitDetailsModel getRoutingExplicitDetailsModel() {
			return routingExplicitDetailsModel;
		}
		
		@Override
		public RoutingExplicitDetails build() {
			return this;
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder() {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RoutingExplicitDetails.RoutingExplicitDetailsBuilder builder) {
			ofNullable(getRoutingExplicitDetailsModel()).ifPresent(builder::setRoutingExplicitDetailsModel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingExplicitDetails _that = getType().cast(o);
		
			if (!Objects.equals(routingExplicitDetailsModel, _that.getRoutingExplicitDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingExplicitDetailsModel != null ? routingExplicitDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetails {" +
				"routingExplicitDetailsModel=" + this.routingExplicitDetailsModel +
			'}';
		}
	}

	/*********************** Builder Implementation of RoutingExplicitDetails  ***********************/
	class RoutingExplicitDetailsBuilderImpl implements RoutingExplicitDetails.RoutingExplicitDetailsBuilder {
	
		protected RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder routingExplicitDetailsModel;
	
		public RoutingExplicitDetailsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getRoutingExplicitDetailsModel() {
			return routingExplicitDetailsModel;
		}
		
		@Override
		public RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder getOrCreateRoutingExplicitDetailsModel() {
			RoutingExplicitDetailsModel.RoutingExplicitDetailsModelBuilder result;
			if (routingExplicitDetailsModel!=null) {
				result = routingExplicitDetailsModel;
			}
			else {
				result = routingExplicitDetailsModel = RoutingExplicitDetailsModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("routingExplicitDetailsModel")
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder setRoutingExplicitDetailsModel(RoutingExplicitDetailsModel routingExplicitDetailsModel) {
			this.routingExplicitDetailsModel = routingExplicitDetailsModel==null?null:routingExplicitDetailsModel.toBuilder();
			return this;
		}
		
		@Override
		public RoutingExplicitDetails build() {
			return new RoutingExplicitDetails.RoutingExplicitDetailsImpl(this);
		}
		
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder prune() {
			if (routingExplicitDetailsModel!=null && !routingExplicitDetailsModel.prune().hasData()) routingExplicitDetailsModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRoutingExplicitDetailsModel()!=null && getRoutingExplicitDetailsModel().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RoutingExplicitDetails.RoutingExplicitDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RoutingExplicitDetails.RoutingExplicitDetailsBuilder o = (RoutingExplicitDetails.RoutingExplicitDetailsBuilder) other;
			
			merger.mergeRosetta(getRoutingExplicitDetailsModel(), o.getRoutingExplicitDetailsModel(), this::setRoutingExplicitDetailsModel);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RoutingExplicitDetails _that = getType().cast(o);
		
			if (!Objects.equals(routingExplicitDetailsModel, _that.getRoutingExplicitDetailsModel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (routingExplicitDetailsModel != null ? routingExplicitDetailsModel.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RoutingExplicitDetailsBuilder {" +
				"routingExplicitDetailsModel=" + this.routingExplicitDetailsModel +
			'}';
		}
	}
}

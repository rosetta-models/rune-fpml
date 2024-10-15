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
import fpml.confirmation.PortfolioReferenceBase;
import fpml.confirmation.PortfolioReferenceBaseModel;
import fpml.confirmation.PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder;
import fpml.confirmation.PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilderImpl;
import fpml.confirmation.PortfolioReferenceBaseModel.PortfolioReferenceBaseModelImpl;
import fpml.confirmation.meta.PortfolioReferenceBaseModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines a model group that allows a portfolio to be identified in a response message.
 * @version ${project.version}
 */
@RosettaDataType(value="PortfolioReferenceBaseModel", builder=PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilderImpl.class, version="${project.version}")
public interface PortfolioReferenceBaseModel extends RosettaModelObject {

	PortfolioReferenceBaseModelMeta metaData = new PortfolioReferenceBaseModelMeta();

	/*********************** Getter Methods  ***********************/
	PortfolioReferenceBase getPortfolioReference();

	/*********************** Build Methods  ***********************/
	PortfolioReferenceBaseModel build();
	
	PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder toBuilder();
	
	static PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder builder() {
		return new PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PortfolioReferenceBaseModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends PortfolioReferenceBaseModel> getType() {
		return PortfolioReferenceBaseModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReferenceBase.class, getPortfolioReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioReferenceBaseModelBuilder extends PortfolioReferenceBaseModel, RosettaModelObjectBuilder {
		PortfolioReferenceBase.PortfolioReferenceBaseBuilder getOrCreatePortfolioReference();
		PortfolioReferenceBase.PortfolioReferenceBaseBuilder getPortfolioReference();
		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder setPortfolioReference(PortfolioReferenceBase portfolioReference);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReferenceBase.PortfolioReferenceBaseBuilder.class, getPortfolioReference());
		}
		

		PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder prune();
	}

	/*********************** Immutable Implementation of PortfolioReferenceBaseModel  ***********************/
	class PortfolioReferenceBaseModelImpl implements PortfolioReferenceBaseModel {
		private final PortfolioReferenceBase portfolioReference;
		
		protected PortfolioReferenceBaseModelImpl(PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder builder) {
			this.portfolioReference = ofNullable(builder.getPortfolioReference()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReferenceBase getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioReferenceBaseModel build() {
			return this;
		}
		
		@Override
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder toBuilder() {
			PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder builder) {
			ofNullable(getPortfolioReference()).ifPresent(builder::setPortfolioReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceBaseModel {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}

	/*********************** Builder Implementation of PortfolioReferenceBaseModel  ***********************/
	class PortfolioReferenceBaseModelBuilderImpl implements PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder {
	
		protected PortfolioReferenceBase.PortfolioReferenceBaseBuilder portfolioReference;
	
		public PortfolioReferenceBaseModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioReferenceBase.PortfolioReferenceBaseBuilder getOrCreatePortfolioReference() {
			PortfolioReferenceBase.PortfolioReferenceBaseBuilder result;
			if (portfolioReference!=null) {
				result = portfolioReference;
			}
			else {
				result = portfolioReference = PortfolioReferenceBase.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder setPortfolioReference(PortfolioReferenceBase portfolioReference) {
			this.portfolioReference = portfolioReference==null?null:portfolioReference.toBuilder();
			return this;
		}
		
		@Override
		public PortfolioReferenceBaseModel build() {
			return new PortfolioReferenceBaseModel.PortfolioReferenceBaseModelImpl(this);
		}
		
		@Override
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder prune() {
			if (portfolioReference!=null && !portfolioReference.prune().hasData()) portfolioReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPortfolioReference()!=null && getPortfolioReference().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder o = (PortfolioReferenceBaseModel.PortfolioReferenceBaseModelBuilder) other;
			
			merger.mergeRosetta(getPortfolioReference(), o.getPortfolioReference(), this::setPortfolioReference);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PortfolioReferenceBaseModel _that = getType().cast(o);
		
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioReferenceBaseModelBuilder {" +
				"portfolioReference=" + this.portfolioReference +
			'}';
		}
	}
}

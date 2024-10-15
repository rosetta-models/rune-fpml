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
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.BasicQuotation.BasicQuotationBuilder;
import fpml.confirmation.BasicQuotation.BasicQuotationBuilderImpl;
import fpml.confirmation.BasicQuotation.BasicQuotationImpl;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.meta.BasicQuotationMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Some kind of numerical measure about an asset, eg. its NPV, together with characteristics of that measure.
 * @version ${project.version}
 */
@RosettaDataType(value="BasicQuotation", builder=BasicQuotation.BasicQuotationBuilderImpl.class, version="${project.version}")
public interface BasicQuotation extends RosettaModelObject {

	BasicQuotationMeta metaData = new BasicQuotationMeta();

	/*********************** Getter Methods  ***********************/
	QuotationModel getQuotationModel();
	String getId();

	/*********************** Build Methods  ***********************/
	BasicQuotation build();
	
	BasicQuotation.BasicQuotationBuilder toBuilder();
	
	static BasicQuotation.BasicQuotationBuilder builder() {
		return new BasicQuotation.BasicQuotationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends BasicQuotation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends BasicQuotation> getType() {
		return BasicQuotation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.class, getQuotationModel());
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface BasicQuotationBuilder extends BasicQuotation, RosettaModelObjectBuilder {
		QuotationModel.QuotationModelBuilder getOrCreateQuotationModel();
		QuotationModel.QuotationModelBuilder getQuotationModel();
		BasicQuotation.BasicQuotationBuilder setQuotationModel(QuotationModel quotationModel);
		BasicQuotation.BasicQuotationBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("quotationModel"), processor, QuotationModel.QuotationModelBuilder.class, getQuotationModel());
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		BasicQuotation.BasicQuotationBuilder prune();
	}

	/*********************** Immutable Implementation of BasicQuotation  ***********************/
	class BasicQuotationImpl implements BasicQuotation {
		private final QuotationModel quotationModel;
		private final String id;
		
		protected BasicQuotationImpl(BasicQuotation.BasicQuotationBuilder builder) {
			this.quotationModel = ofNullable(builder.getQuotationModel()).map(f->f.build()).orElse(null);
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public BasicQuotation build() {
			return this;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder toBuilder() {
			BasicQuotation.BasicQuotationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BasicQuotation.BasicQuotationBuilder builder) {
			ofNullable(getQuotationModel()).ifPresent(builder::setQuotationModel);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasicQuotation _that = getType().cast(o);
		
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicQuotation {" +
				"quotationModel=" + this.quotationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of BasicQuotation  ***********************/
	class BasicQuotationBuilderImpl implements BasicQuotation.BasicQuotationBuilder {
	
		protected QuotationModel.QuotationModelBuilder quotationModel;
		protected String id;
	
		public BasicQuotationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("quotationModel")
		public QuotationModel.QuotationModelBuilder getQuotationModel() {
			return quotationModel;
		}
		
		@Override
		public QuotationModel.QuotationModelBuilder getOrCreateQuotationModel() {
			QuotationModel.QuotationModelBuilder result;
			if (quotationModel!=null) {
				result = quotationModel;
			}
			else {
				result = quotationModel = QuotationModel.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("quotationModel")
		public BasicQuotation.BasicQuotationBuilder setQuotationModel(QuotationModel quotationModel) {
			this.quotationModel = quotationModel==null?null:quotationModel.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("id")
		public BasicQuotation.BasicQuotationBuilder setId(String id) {
			this.id = id==null?null:id;
			return this;
		}
		
		@Override
		public BasicQuotation build() {
			return new BasicQuotation.BasicQuotationImpl(this);
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicQuotation.BasicQuotationBuilder prune() {
			if (quotationModel!=null && !quotationModel.prune().hasData()) quotationModel = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQuotationModel()!=null && getQuotationModel().hasData()) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BasicQuotation.BasicQuotationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BasicQuotation.BasicQuotationBuilder o = (BasicQuotation.BasicQuotationBuilder) other;
			
			merger.mergeRosetta(getQuotationModel(), o.getQuotationModel(), this::setQuotationModel);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BasicQuotation _that = getType().cast(o);
		
			if (!Objects.equals(quotationModel, _that.getQuotationModel())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (quotationModel != null ? quotationModel.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BasicQuotationBuilder {" +
				"quotationModel=" + this.quotationModel + ", " +
				"id=" + this.id +
			'}';
		}
	}
}

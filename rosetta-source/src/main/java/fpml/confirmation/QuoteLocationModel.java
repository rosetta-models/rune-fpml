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
import fpml.confirmation.BusinessCenter;
import fpml.confirmation.ExchangeId;
import fpml.confirmation.QuoteLocationModel;
import fpml.confirmation.QuoteLocationModel.QuoteLocationModelBuilder;
import fpml.confirmation.QuoteLocationModel.QuoteLocationModelBuilderImpl;
import fpml.confirmation.QuoteLocationModel.QuoteLocationModelImpl;
import fpml.confirmation.meta.QuoteLocationModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A group describing where a quote was or will be obtained, e.g. observed or calculated.
 * @version ${project.version}
 */
@RosettaDataType(value="QuoteLocationModel", builder=QuoteLocationModel.QuoteLocationModelBuilderImpl.class, version="${project.version}")
public interface QuoteLocationModel extends RosettaModelObject {

	QuoteLocationModelMeta metaData = new QuoteLocationModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A city or other business center.
	 */
	BusinessCenter getBusinessCenter();
	/**
	 * The exchange (e.g. stock or futures exchange) from which the quote is obtained.
	 */
	ExchangeId getExchangeId();

	/*********************** Build Methods  ***********************/
	QuoteLocationModel build();
	
	QuoteLocationModel.QuoteLocationModelBuilder toBuilder();
	
	static QuoteLocationModel.QuoteLocationModelBuilder builder() {
		return new QuoteLocationModel.QuoteLocationModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QuoteLocationModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends QuoteLocationModel> getType() {
		return QuoteLocationModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.class, getBusinessCenter());
		processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.class, getExchangeId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QuoteLocationModelBuilder extends QuoteLocationModel, RosettaModelObjectBuilder {
		BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter();
		BusinessCenter.BusinessCenterBuilder getBusinessCenter();
		ExchangeId.ExchangeIdBuilder getOrCreateExchangeId();
		ExchangeId.ExchangeIdBuilder getExchangeId();
		QuoteLocationModel.QuoteLocationModelBuilder setBusinessCenter(BusinessCenter businessCenter);
		QuoteLocationModel.QuoteLocationModelBuilder setExchangeId(ExchangeId exchangeId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("businessCenter"), processor, BusinessCenter.BusinessCenterBuilder.class, getBusinessCenter());
			processRosetta(path.newSubPath("exchangeId"), processor, ExchangeId.ExchangeIdBuilder.class, getExchangeId());
		}
		

		QuoteLocationModel.QuoteLocationModelBuilder prune();
	}

	/*********************** Immutable Implementation of QuoteLocationModel  ***********************/
	class QuoteLocationModelImpl implements QuoteLocationModel {
		private final BusinessCenter businessCenter;
		private final ExchangeId exchangeId;
		
		protected QuoteLocationModelImpl(QuoteLocationModel.QuoteLocationModelBuilder builder) {
			this.businessCenter = ofNullable(builder.getBusinessCenter()).map(f->f.build()).orElse(null);
			this.exchangeId = ofNullable(builder.getExchangeId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeId getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public QuoteLocationModel build() {
			return this;
		}
		
		@Override
		public QuoteLocationModel.QuoteLocationModelBuilder toBuilder() {
			QuoteLocationModel.QuoteLocationModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QuoteLocationModel.QuoteLocationModelBuilder builder) {
			ofNullable(getBusinessCenter()).ifPresent(builder::setBusinessCenter);
			ofNullable(getExchangeId()).ifPresent(builder::setExchangeId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuoteLocationModel _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuoteLocationModel {" +
				"businessCenter=" + this.businessCenter + ", " +
				"exchangeId=" + this.exchangeId +
			'}';
		}
	}

	/*********************** Builder Implementation of QuoteLocationModel  ***********************/
	class QuoteLocationModelBuilderImpl implements QuoteLocationModel.QuoteLocationModelBuilder {
	
		protected BusinessCenter.BusinessCenterBuilder businessCenter;
		protected ExchangeId.ExchangeIdBuilder exchangeId;
	
		public QuoteLocationModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("businessCenter")
		public BusinessCenter.BusinessCenterBuilder getBusinessCenter() {
			return businessCenter;
		}
		
		@Override
		public BusinessCenter.BusinessCenterBuilder getOrCreateBusinessCenter() {
			BusinessCenter.BusinessCenterBuilder result;
			if (businessCenter!=null) {
				result = businessCenter;
			}
			else {
				result = businessCenter = BusinessCenter.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("exchangeId")
		public ExchangeId.ExchangeIdBuilder getExchangeId() {
			return exchangeId;
		}
		
		@Override
		public ExchangeId.ExchangeIdBuilder getOrCreateExchangeId() {
			ExchangeId.ExchangeIdBuilder result;
			if (exchangeId!=null) {
				result = exchangeId;
			}
			else {
				result = exchangeId = ExchangeId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("businessCenter")
		public QuoteLocationModel.QuoteLocationModelBuilder setBusinessCenter(BusinessCenter businessCenter) {
			this.businessCenter = businessCenter==null?null:businessCenter.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("exchangeId")
		public QuoteLocationModel.QuoteLocationModelBuilder setExchangeId(ExchangeId exchangeId) {
			this.exchangeId = exchangeId==null?null:exchangeId.toBuilder();
			return this;
		}
		
		@Override
		public QuoteLocationModel build() {
			return new QuoteLocationModel.QuoteLocationModelImpl(this);
		}
		
		@Override
		public QuoteLocationModel.QuoteLocationModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuoteLocationModel.QuoteLocationModelBuilder prune() {
			if (businessCenter!=null && !businessCenter.prune().hasData()) businessCenter = null;
			if (exchangeId!=null && !exchangeId.prune().hasData()) exchangeId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBusinessCenter()!=null && getBusinessCenter().hasData()) return true;
			if (getExchangeId()!=null && getExchangeId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QuoteLocationModel.QuoteLocationModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QuoteLocationModel.QuoteLocationModelBuilder o = (QuoteLocationModel.QuoteLocationModelBuilder) other;
			
			merger.mergeRosetta(getBusinessCenter(), o.getBusinessCenter(), this::setBusinessCenter);
			merger.mergeRosetta(getExchangeId(), o.getExchangeId(), this::setExchangeId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QuoteLocationModel _that = getType().cast(o);
		
			if (!Objects.equals(businessCenter, _that.getBusinessCenter())) return false;
			if (!Objects.equals(exchangeId, _that.getExchangeId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (businessCenter != null ? businessCenter.hashCode() : 0);
			_result = 31 * _result + (exchangeId != null ? exchangeId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QuoteLocationModelBuilder {" +
				"businessCenter=" + this.businessCenter + ", " +
				"exchangeId=" + this.exchangeId +
			'}';
		}
	}
}

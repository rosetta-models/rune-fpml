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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.ContractualSupplement;
import fpml.confirmation.ContractualTermsSupplement;
import fpml.confirmation.ContractualTermsSupplement.ContractualTermsSupplementBuilder;
import fpml.confirmation.ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl;
import fpml.confirmation.ContractualTermsSupplement.ContractualTermsSupplementImpl;
import fpml.confirmation.meta.ContractualTermsSupplementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A contractual supplement (such as those published by ISDA) and its publication date that will apply to the trade.
 * @version ${project.version}
 */
@RosettaDataType(value="ContractualTermsSupplement", builder=ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl.class, version="${project.version}")
public interface ContractualTermsSupplement extends RosettaModelObject {

	ContractualTermsSupplementMeta metaData = new ContractualTermsSupplementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Identifies the form of applicable contractual supplement.
	 */
	ContractualSupplement getType();
	/**
	 * Specifies the publication date of the applicable version of the contractual supplement.
	 */
	Date getPublicationDate();

	/*********************** Build Methods  ***********************/
	ContractualTermsSupplement build();
	
	ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder();
	
	static ContractualTermsSupplement.ContractualTermsSupplementBuilder builder() {
		return new ContractualTermsSupplement.ContractualTermsSupplementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ContractualTermsSupplement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends ContractualTermsSupplement> getType() {
		return ContractualTermsSupplement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("type"), processor, ContractualSupplement.class, getType());
		processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ContractualTermsSupplementBuilder extends ContractualTermsSupplement, RosettaModelObjectBuilder {
		ContractualSupplement.ContractualSupplementBuilder getOrCreateType();
		ContractualSupplement.ContractualSupplementBuilder getType();
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setType(ContractualSupplement type);
		ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(Date publicationDate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("type"), processor, ContractualSupplement.ContractualSupplementBuilder.class, getType());
			processor.processBasic(path.newSubPath("publicationDate"), Date.class, getPublicationDate(), this);
		}
		

		ContractualTermsSupplement.ContractualTermsSupplementBuilder prune();
	}

	/*********************** Immutable Implementation of ContractualTermsSupplement  ***********************/
	class ContractualTermsSupplementImpl implements ContractualTermsSupplement {
		private final ContractualSupplement type;
		private final Date publicationDate;
		
		protected ContractualTermsSupplementImpl(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			this.type = ofNullable(builder.getType()).map(f->f.build()).orElse(null);
			this.publicationDate = builder.getPublicationDate();
		}
		
		@Override
		@RosettaAttribute("type")
		public ContractualSupplement getType() {
			return type;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return this;
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ContractualTermsSupplement.ContractualTermsSupplementBuilder builder) {
			ofNullable(getType()).ifPresent(builder::setType);
			ofNullable(getPublicationDate()).ifPresent(builder::setPublicationDate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplement {" +
				"type=" + this.type + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}

	/*********************** Builder Implementation of ContractualTermsSupplement  ***********************/
	class ContractualTermsSupplementBuilderImpl implements ContractualTermsSupplement.ContractualTermsSupplementBuilder {
	
		protected ContractualSupplement.ContractualSupplementBuilder type;
		protected Date publicationDate;
	
		public ContractualTermsSupplementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("type")
		public ContractualSupplement.ContractualSupplementBuilder getType() {
			return type;
		}
		
		@Override
		public ContractualSupplement.ContractualSupplementBuilder getOrCreateType() {
			ContractualSupplement.ContractualSupplementBuilder result;
			if (type!=null) {
				result = type;
			}
			else {
				result = type = ContractualSupplement.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationDate")
		public Date getPublicationDate() {
			return publicationDate;
		}
		
		@Override
		@RosettaAttribute("type")
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setType(ContractualSupplement type) {
			this.type = type==null?null:type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("publicationDate")
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder setPublicationDate(Date publicationDate) {
			this.publicationDate = publicationDate==null?null:publicationDate;
			return this;
		}
		
		@Override
		public ContractualTermsSupplement build() {
			return new ContractualTermsSupplement.ContractualTermsSupplementImpl(this);
		}
		
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder prune() {
			if (type!=null && !type.prune().hasData()) type = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getType()!=null && getType().hasData()) return true;
			if (getPublicationDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ContractualTermsSupplement.ContractualTermsSupplementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ContractualTermsSupplement.ContractualTermsSupplementBuilder o = (ContractualTermsSupplement.ContractualTermsSupplementBuilder) other;
			
			merger.mergeRosetta(getType(), o.getType(), this::setType);
			
			merger.mergeBasic(getPublicationDate(), o.getPublicationDate(), this::setPublicationDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ContractualTermsSupplement _that = getType().cast(o);
		
			if (!Objects.equals(type, _that.getType())) return false;
			if (!Objects.equals(publicationDate, _that.getPublicationDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (type != null ? type.hashCode() : 0);
			_result = 31 * _result + (publicationDate != null ? publicationDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ContractualTermsSupplementBuilder {" +
				"type=" + this.type + ", " +
				"publicationDate=" + this.publicationDate +
			'}';
		}
	}
}

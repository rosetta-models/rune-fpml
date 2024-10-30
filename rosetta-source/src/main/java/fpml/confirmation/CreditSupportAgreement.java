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
import fpml.confirmation.CreditSupportAgreement;
import fpml.confirmation.CreditSupportAgreement.CreditSupportAgreementBuilder;
import fpml.confirmation.CreditSupportAgreement.CreditSupportAgreementBuilderImpl;
import fpml.confirmation.CreditSupportAgreement.CreditSupportAgreementImpl;
import fpml.confirmation.CreditSupportAgreementIdentifier;
import fpml.confirmation.CreditSupportAgreementType;
import fpml.confirmation.meta.CreditSupportAgreementMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * The agreement executed between the parties and intended to govern collateral arrangement for all OTC derivatives transactions between those parties.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CreditSupportAgreement", builder=CreditSupportAgreement.CreditSupportAgreementBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CreditSupportAgreement extends RosettaModelObject {

	CreditSupportAgreementMeta metaData = new CreditSupportAgreementMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The type of ISDA Credit Support Agreement
	 */
	CreditSupportAgreementType get_type();
	/**
	 * The date of the agreement executed between the parties and intended to govern collateral arrangements for all OTC derivatives transactions between those parties.
	 */
	Date getDate();
	/**
	 * An identifier used to uniquely identify the CSA
	 */
	CreditSupportAgreementIdentifier getIdentifier();

	/*********************** Build Methods  ***********************/
	CreditSupportAgreement build();
	
	CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder();
	
	static CreditSupportAgreement.CreditSupportAgreementBuilder builder() {
		return new CreditSupportAgreement.CreditSupportAgreementBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CreditSupportAgreement> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CreditSupportAgreement> getType() {
		return CreditSupportAgreement.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("_type"), processor, CreditSupportAgreementType.class, get_type());
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processRosetta(path.newSubPath("identifier"), processor, CreditSupportAgreementIdentifier.class, getIdentifier());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CreditSupportAgreementBuilder extends CreditSupportAgreement, RosettaModelObjectBuilder {
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder getOrCreate_type();
		CreditSupportAgreementType.CreditSupportAgreementTypeBuilder get_type();
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getOrCreateIdentifier();
		CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getIdentifier();
		CreditSupportAgreement.CreditSupportAgreementBuilder set_type(CreditSupportAgreementType _type);
		CreditSupportAgreement.CreditSupportAgreementBuilder setDate(Date date);
		CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifier(CreditSupportAgreementIdentifier identifier);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("_type"), processor, CreditSupportAgreementType.CreditSupportAgreementTypeBuilder.class, get_type());
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processRosetta(path.newSubPath("identifier"), processor, CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder.class, getIdentifier());
		}
		

		CreditSupportAgreement.CreditSupportAgreementBuilder prune();
	}

	/*********************** Immutable Implementation of CreditSupportAgreement  ***********************/
	class CreditSupportAgreementImpl implements CreditSupportAgreement {
		private final CreditSupportAgreementType _type;
		private final Date date;
		private final CreditSupportAgreementIdentifier identifier;
		
		protected CreditSupportAgreementImpl(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			this._type = ofNullable(builder.get_type()).map(f->f.build()).orElse(null);
			this.date = builder.getDate();
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("_type")
		public CreditSupportAgreementType get_type() {
			return _type;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public CreditSupportAgreementIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return this;
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			CreditSupportAgreement.CreditSupportAgreementBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CreditSupportAgreement.CreditSupportAgreementBuilder builder) {
			ofNullable(get_type()).ifPresent(builder::set_type);
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreement {" +
				"_type=" + this._type + ", " +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}

	/*********************** Builder Implementation of CreditSupportAgreement  ***********************/
	class CreditSupportAgreementBuilderImpl implements CreditSupportAgreement.CreditSupportAgreementBuilder {
	
		protected CreditSupportAgreementType.CreditSupportAgreementTypeBuilder _type;
		protected Date date;
		protected CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder identifier;
	
		public CreditSupportAgreementBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("_type")
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder get_type() {
			return _type;
		}
		
		@Override
		public CreditSupportAgreementType.CreditSupportAgreementTypeBuilder getOrCreate_type() {
			CreditSupportAgreementType.CreditSupportAgreementTypeBuilder result;
			if (_type!=null) {
				result = _type;
			}
			else {
				result = _type = CreditSupportAgreementType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("identifier")
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder getOrCreateIdentifier() {
			CreditSupportAgreementIdentifier.CreditSupportAgreementIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = CreditSupportAgreementIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("_type")
		public CreditSupportAgreement.CreditSupportAgreementBuilder set_type(CreditSupportAgreementType _type) {
			this._type = _type==null?null:_type.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("date")
		public CreditSupportAgreement.CreditSupportAgreementBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("identifier")
		public CreditSupportAgreement.CreditSupportAgreementBuilder setIdentifier(CreditSupportAgreementIdentifier identifier) {
			this.identifier = identifier==null?null:identifier.toBuilder();
			return this;
		}
		
		@Override
		public CreditSupportAgreement build() {
			return new CreditSupportAgreement.CreditSupportAgreementImpl(this);
		}
		
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder prune() {
			if (_type!=null && !_type.prune().hasData()) _type = null;
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (get_type()!=null && get_type().hasData()) return true;
			if (getDate()!=null) return true;
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CreditSupportAgreement.CreditSupportAgreementBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CreditSupportAgreement.CreditSupportAgreementBuilder o = (CreditSupportAgreement.CreditSupportAgreementBuilder) other;
			
			merger.mergeRosetta(get_type(), o.get_type(), this::set_type);
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CreditSupportAgreement _that = getType().cast(o);
		
			if (!Objects.equals(_type, _that.get_type())) return false;
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (_type != null ? _type.hashCode() : 0);
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CreditSupportAgreementBuilder {" +
				"_type=" + this._type + ", " +
				"date=" + this.date + ", " +
				"identifier=" + this.identifier +
			'}';
		}
	}
}

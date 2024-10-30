package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.X509IssuerSerialType;
import fpml.confirmation.validation.X509IssuerSerialTypeTypeFormatValidator;
import fpml.confirmation.validation.X509IssuerSerialTypeValidator;
import fpml.confirmation.validation.exists.X509IssuerSerialTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=X509IssuerSerialType.class)
public class X509IssuerSerialTypeMeta implements RosettaMetaData<X509IssuerSerialType> {

	@Override
	public List<Validator<? super X509IssuerSerialType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super X509IssuerSerialType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super X509IssuerSerialType> validator() {
		return new X509IssuerSerialTypeValidator();
	}

	@Override
	public Validator<? super X509IssuerSerialType> typeFormatValidator() {
		return new X509IssuerSerialTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super X509IssuerSerialType, Set<String>> onlyExistsValidator() {
		return new X509IssuerSerialTypeOnlyExistsValidator();
	}
}
